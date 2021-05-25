package braces.server.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.CheckedOutputStream;

import braces.Exchanger.ClientExchanger;

public class ServerRun {
	  private static Selector selector = null;
	  private static int valueOfByteBuffer =65536;
	  Handler handler;
	  public ServerRun(Handler handler) {
		this.handler = handler;
	}
	  
	  public void start() throws ClassNotFoundException {
	        try {
	            selector = Selector.open();
	            ServerSocketChannel socket = ServerSocketChannel.open();
	            ServerSocket serverSocket = socket.socket();
	            System.out.println("Server is started...");
	            serverSocket.bind(new InetSocketAddress("localhost", 6963));
	            socket.configureBlocking(false);
	            int ops = socket.validOps();
	            SelectionKey selectKy = socket.register(selector, ops, null);  
	            ClientExchanger exchangeClass = new ClientExchanger();
	            for(;;) {		
	                int noOfKeys = selector.select();  
	                System.out.println("The Number of selected keys are: " + noOfKeys);  
	                Set<SelectionKey> selectedKeys = selector.selectedKeys();
	                Iterator<SelectionKey> i = selectedKeys.iterator();
	                while (i.hasNext()) {	
	                    SelectionKey key = i.next();
	                    if (key.isAcceptable()) {
	                        SocketChannel client = socket.accept();  
	                        client.configureBlocking(false);  
	                        // The new connection is added to a selector  
	                        client.register(selector, SelectionKey.OP_READ);  
	                        System.out.println("The new connection is accepted from the client: " + client);  
	                    } else if (key.isReadable()) {
	                    	  SocketChannel client = (SocketChannel) key.channel();  
	                          ByteBuffer buffer = ByteBuffer.allocate(65536);  
	                          client.read(buffer);  
	                          String output = new String(buffer.array()).trim();  
	                          exchangeClass = deserialize(buffer.array());

	                          exchangeClass= handler.startCommand(exchangeClass);
	                          System.out.println(exchangeClass);
	                          client.register(selector, SelectionKey.OP_WRITE);
	                    } else if (key.isWritable()) {
	                    	 SocketChannel client = (SocketChannel) key.channel();  
	                         ByteBuffer buffer = ByteBuffer.allocate(65536);  
	                         clear(buffer);
	                         buffer.put(serialize(exchangeClass));  
	                         flip(buffer);
	                         
	                         while(buffer.hasRemaining()) {  
	                        	    client.write(buffer);  
	                        	}  
	                       client.register(selector, SelectionKey.OP_READ);
	                    }
	                    i.remove();
	                }
	            }
	        } catch (BindException e) {
	            System.out.println("Can't use this port!");
	            System.exit(-1);
	        } catch (IOException e) {
	            System.out.println("Server down.");
	            System.exit(-1);
	        }
	    }
	  	public static void clear(Buffer buffer)
	  	{
	      buffer.clear();
	  	}

	  	public static void flip(Buffer buffer)
	  	{
	  		buffer.flip();
	  	}


	    public byte[] serialize(Object obj) throws IOException {
	        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
	            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
	                o.writeObject(obj);
	            }
	            return b.toByteArray();
	        }
	    }

	    public  ClientExchanger deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
	        try (ByteArrayInputStream b = new ByteArrayInputStream(bytes)) {
	            try (ObjectInputStream o = new ObjectInputStream(b)) {
	                return (ClientExchanger) o.readObject();
	            }
	        }
	    }
}

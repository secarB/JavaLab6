package braces.server.main;

import braces.server.commands.*;
import braces.server.core.*;

import java.util.Scanner;

/**
 * Main class
 * @author Braces
 * @version 1.0
 */
public class ServerMain
{
    static String fileName ;
    public static void main(String[] args) throws ClassNotFoundException {
        try {
       fileName = args[0];
       // fileName = "E:/test.csv";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please insert file input via command line argument!");
            System.exit(-1);
        }
        CollectionManager collectionManager = new CollectionManager();
        InputChecker inputChecker = new InputChecker();
        collectionManager.readInput(fileName);
        Asker asker = new Asker(inputChecker);
        CommandManager commandManager = new CommandManager(
                new ClearCommand(collectionManager),
                new AverageOfHealthCommand(collectionManager),
                new CountGreaterThanHeightCommand(collectionManager,inputChecker),
                new ExitCommand(),
                new HelpCommand(collectionManager),
                new InfoCommand(collectionManager),
                new InsertCommand(collectionManager,asker),
                new MinByHealthCommand(collectionManager),
                new RemoveCommand(collectionManager,asker),
                new RemoveGreaterCommand(collectionManager,asker),
                new ReplaceIfGreaterCommand(collectionManager,asker),
                new SaveCommand(collectionManager),
                new ShowCommand(collectionManager),
                new UpdateCommand(collectionManager,asker),
                new RemoveLowerCommand(collectionManager,asker)
        );
        
        Handler handler = new Handler(commandManager);
        ServerRun server = new ServerRun(handler);
        server.start();
    }
}

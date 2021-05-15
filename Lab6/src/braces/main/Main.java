package braces.main;

import braces.core.*;
import braces.server.commands.*;

import java.util.Scanner;

/**
 * Main class
 * @author Braces
 * @version 1.0
 */
public class Main
{
    static String fileName ;
    public static void main(String[] args) {
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
        Commander commander = new Commander(fileName,new Scanner(System.in),commandManager);
        System.out.println("Hello");
        System.out.println("To get started type help to view the commands ");
        commander.interactiveMode();  
    }
}

package braces.server.commands;

import java.util.Scanner;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for replace if greater command
 */
public class ReplaceIfGreaterCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Asker asker;
    public ReplaceIfGreaterCommand(CollectionManager collectionManager, Asker asker)
    {
        this.asker = asker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument,Scanner scanner) {
    	asker.changeScanner(scanner);
        if (collectionManager.replaceGreater(argument,asker.createSpaceMarine())) return true;
        System.out.println("Key does not exist");
        return false;
    }
}

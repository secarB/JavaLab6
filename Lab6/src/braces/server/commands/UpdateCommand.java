package braces.server.commands;

import java.util.Scanner;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for update command
 */
public class UpdateCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Asker asker;
    public  UpdateCommand(CollectionManager collectionManager, Asker asker)
    {
        this.asker = asker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument,Scanner scanner) {
    	asker.changeScanner(scanner);
        long id = Long.parseLong(argument);
        if (collectionManager.update(id, asker.updateSpaceMarine(id))) return true;
        System.out.println("Can't find id:");
        return false;
    }
}

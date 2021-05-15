package braces.server.commands;

import java.util.Scanner;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for remove greater command
 */
public class RemoveGreaterCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Asker asker;
    public RemoveGreaterCommand(CollectionManager collectionManager, Asker asker)
    {
        this.asker = asker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(Scanner scanner) {
    	asker.changeScanner(scanner);
        collectionManager.removeGreater(asker.createSpaceMarine());
        return true;
    }
}

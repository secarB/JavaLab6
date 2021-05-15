package braces.server.commands;

import java.util.Scanner;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for remove lower command
 */
public class RemoveLowerCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Asker asker;
    public RemoveLowerCommand(CollectionManager collectionManager, Asker asker)
    {
        this.asker = asker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(Scanner scanner) {
    	asker.changeScanner(scanner);
        collectionManager.removeLower(asker.createSpaceMarine());
        return true;
    }
}

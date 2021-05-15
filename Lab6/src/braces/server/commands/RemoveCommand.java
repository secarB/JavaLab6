package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for remove command
 */
public class RemoveCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveCommand(CollectionManager collectionManager, Asker asker)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        int key = Integer.parseInt(argument);
        if (collectionManager.remove(key)) return true;
        System.out.println("Key does not exist");
        return false;
    }
}

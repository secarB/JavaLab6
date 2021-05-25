package braces.server.commands;

import braces.server.core.Asker;
import braces.server.core.CollectionManager;
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
    public String execute(String argument) {
        int key = Integer.parseInt(argument);
        if (collectionManager.remove(key)) return "Removed successful";
        return("Key does not exist");

    }
}

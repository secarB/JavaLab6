package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for min by health command
 */
public class MinByHealthCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public  MinByHealthCommand(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute() {
        collectionManager.minByHealth();
        return true;
    }
}

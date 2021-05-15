package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for clear command
 */
public class ClearCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute() {
        collectionManager.clear();
        return true;
    }
}

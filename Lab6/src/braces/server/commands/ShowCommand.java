package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for show command
 */
public class ShowCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private Asker asker;
    public ShowCommand(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute() {
        collectionManager.show();
        return true;
    }
}

package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for help command
 */
public class HelpCommand extends AbstractCommand{
    private CollectionManager   collectionManager;
    public HelpCommand(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute() {
        collectionManager.help();
        return true;
    }
}

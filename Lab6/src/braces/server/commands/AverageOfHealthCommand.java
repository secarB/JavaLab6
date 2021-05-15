package braces.server.commands;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for the get average of health command
 */
public class AverageOfHealthCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public  AverageOfHealthCommand(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute() {
        System.out.println(collectionManager.getAverageOfHealth());
        return true;
    }
}

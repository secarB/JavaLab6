package braces.server.commands;

import braces.core.InputChecker;
import braces.core.CollectionManager;
/**
 * Class for count greater than height command
 */
public class CountGreaterThanHeightCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private InputChecker inputChecker;
    public CountGreaterThanHeightCommand(CollectionManager collectionManager,InputChecker inputChecker)
    {
        this.collectionManager = collectionManager;
        this.inputChecker = inputChecker;
    }
    @Override
    public boolean execute(String argument) {
        if (inputChecker.longValidCheck(argument, (long) 0 , Long.MAX_VALUE)) {
            long height = Long.parseLong(argument);
            collectionManager.countGreaterThanHeight(height);
            return true;
        }
        System.out.println("The height value is not in valid range");
        return false;
    }
}

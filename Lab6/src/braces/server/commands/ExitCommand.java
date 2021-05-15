package braces.server.commands;

import braces.core.CollectionManager;
/**
 * Class for exit command
 */
public class ExitCommand extends AbstractCommand{
    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }
}

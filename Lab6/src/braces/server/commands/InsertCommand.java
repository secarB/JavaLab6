package braces.server.commands;

import java.util.Scanner;

import braces.core.Asker;
import braces.core.CollectionManager;
/**
 * Class for insert command
 */
public class InsertCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private Asker asker;
    public InsertCommand(CollectionManager collectionManager, Asker asker)
    {
        this.asker = asker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument, Scanner scanner)
    {
    	asker.changeScanner(scanner);
        if (collectionManager.add(argument,asker.createSpaceMarine())) return true;
        System.out.println("Key already exists");
        asker.backScanner();
        return false;
    }
}

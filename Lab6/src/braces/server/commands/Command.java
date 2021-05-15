package braces.server.commands;

import java.util.Scanner;

/**
 * Interface for all command class
 */
public interface Command {
    boolean execute(String argument);
    boolean execute();
    boolean execute(String argument,Scanner scanner);
    boolean execute(Scanner scanner);
}

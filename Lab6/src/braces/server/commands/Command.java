package braces.server.commands;

import java.util.Scanner;

import braces.server.fields.SpaceMarine;

/**
 * Interface for all command class
 */
public interface Command {
    String execute(String argument);
    String execute();
    String execute(String argument,Scanner scanner);

    String execute(String argument,SpaceMarine spaceMarine);
    String execute(Scanner scanner);
    String execute(SpaceMarine spaceMarine);
}

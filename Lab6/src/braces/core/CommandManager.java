package braces.core;

import java.util.Scanner;

import braces.server.commands.*;

/**
 * Executor of all commands
 */
public class CommandManager {
    private final Command ClearCommand;
    private final Command AverageOfHealthCommand;
    private final Command CountGreaterThanHeightCommand;
    private final Command ExitCommand;
    private final Command HelpCommand;
    private final Command InfoCommand;
    private final Command InsertCommand;
    private final Command MinByHealthCommand;
    private final Command RemoveCommand;
    private final Command RemoveGreaterCommand;
    private final Command ReplaceIfGreaterCommand;
    private final Command SaveCommand;
    private final Command ShowCommand;
    private final Command UpdateCommand;
    private final Command RemoveLowerCommand;

    public CommandManager(Command clearCommand, Command averageOfHealthCommand, Command countGreaterThanHeightCommand,
                          Command exitCommand, Command helpCommand, Command infoCommand,
                          Command insertCommand, Command minByHealthCommand, Command removeCommand,
                          Command removeGreaterCommand, Command replaceIfGreaterCommand,
                          Command saveCommand, Command showCommand, Command updateCommand, Command removeLowerCommand)
    {
        ClearCommand = clearCommand;
        AverageOfHealthCommand = averageOfHealthCommand;
        CountGreaterThanHeightCommand = countGreaterThanHeightCommand;
        ExitCommand = exitCommand;
        HelpCommand = helpCommand;
        InfoCommand = infoCommand;
        InsertCommand = insertCommand;
        MinByHealthCommand = minByHealthCommand;
        RemoveCommand = removeCommand;
        RemoveGreaterCommand = removeGreaterCommand;
        ReplaceIfGreaterCommand = replaceIfGreaterCommand;
        SaveCommand = saveCommand;
        ShowCommand = showCommand;
        UpdateCommand = updateCommand;
        RemoveLowerCommand = removeLowerCommand;
    }
    public boolean average()
    {
        return AverageOfHealthCommand.execute();
    }

    public boolean countGreaterThanHeight(String argument)
    {
        return CountGreaterThanHeightCommand.execute(argument);
    }
    public boolean insert(String argument,Scanner scanner)
    {
        return  InsertCommand.execute(argument,scanner);
    }
    public boolean minByHealth()
    {
        return MinByHealthCommand.execute();
    }
    public boolean remove(String argument)
    {
        return RemoveCommand.execute(argument);
    }
    public boolean removeGreater(Scanner scanner)
    {
        return RemoveGreaterCommand.execute(scanner);
    }
    public boolean removeLower(Scanner scanner)
    {
        return RemoveLowerCommand.execute(scanner);
    }
    public boolean replaceIfGreater(String argument,Scanner scanner)
    {
        return ReplaceIfGreaterCommand.execute(argument,scanner);
    }
    public boolean update(String argument,Scanner scanner)
    {
        return UpdateCommand.execute(argument,scanner);
    }
    public boolean clear()
    {
        return ClearCommand.execute();
    }
    public boolean help(){
        return HelpCommand.execute();
    }
    public boolean info(){
        return InfoCommand.execute();
    }
    public boolean show(){
        return ShowCommand.execute();
    }
    public boolean save(String fileName){
        return SaveCommand.execute(fileName);
    }
    public boolean exit(){
        return ExitCommand.execute();
    }
}

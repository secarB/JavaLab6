package braces.server.core;

import java.util.Scanner;

import braces.Exchanger.ClientExchanger;
import braces.server.fields.SpaceMarine;

public class Handler {
    private  CommandManager commandManager;
    public Handler(CommandManager commandManager) {
    	this.commandManager = commandManager;
	}
    public  ClientExchanger startCommand(ClientExchanger s) {
        try {
            switch (s.getName().trim()) {
            case "help":
            	s.setAnswer(commandManager.help());
            	break;
            case "info":
            	s.setAnswer(commandManager.info());
            	break;
            case "show":
            	s.setAnswer(commandManager.show());
            	break;
            case "insert":
            	s.setAnswer(commandManager.insert(s.getArgument(),s.getSpaceMarine()));
            	break;
            case "clear":
            	s.setAnswer(commandManager.clear());
            	break;
            case "exit":
            	s.setAnswer(commandManager.exit());		
            	break;
            case "update":
            	s.setAnswer(commandManager.update(s.getArgument(), s.getSpaceMarine()));
            	break;
            case "remove_key":
            	s.setAnswer(commandManager.remove(s.getArgument()));
            	break;
            case "remove_greater":
            	s.setAnswer(commandManager.removeGreater(s.getSpaceMarine()));
            	break;
            case "remove_lower":
            	s.setAnswer(commandManager.removeLower(s.getSpaceMarine()));
            	break;
            case "replace_if_greater":
            	s.setAnswer(commandManager.replaceIfGreater(s.getArgument(),s.getSpaceMarine()));
            	break;
            case "average_of_health":
            	s.setAnswer(commandManager.average());
            	break;
            case "min_by_health":
            	s.setAnswer(commandManager.minByHealth());
            	break;
            case "count_greater_than_height":
            	s.setAnswer(commandManager.countGreaterThanHeight(s.getArgument()));
            	break;
            case "save":
            	s.setAnswer(commandManager.save(s.getArgument()));
            	break;
            default:
            	 System.out.println("Your command is not supported. Please insert correct name!\n" +
                         "Use help command to show the guideline.");
            	 break;
                   
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Что-то пошло не так");
        }
        return s;
    }
}

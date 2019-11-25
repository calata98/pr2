package command;

import game.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("Help", "h","Help","Prints this help message.");
	}

	public boolean execute(Game game) {
		System.out.println("The available commands are:");
		CommandGenerator.commandHelp();
		System.out.println("");
		System.out.print("Set command > ");
		return false;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		if(commandWords[0].toLowerCase().equals("h")||commandWords[0].toLowerCase().equals("help")) {
			command = new HelpCommand();
		}
		return command;
	}
}
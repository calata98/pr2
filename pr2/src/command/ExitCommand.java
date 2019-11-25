package command;

import game.Game;

public class ExitCommand extends Command {
	public ExitCommand() {
		super("Exit","e","Exit","Terminates the program.");
	}
	public boolean execute(Game game) {
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		 if(commandWords[0].toLowerCase().equals("e")||commandWords[0].toLowerCase().equals("exit")) {
			command = new ExitCommand();
		}
	return command;
	}
}
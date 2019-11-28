package command;

import game.Game;

public class StringifyCommand extends Command {

	public StringifyCommand() {
		super("Stringify","Stringify","List","Prints the list of available ships. ");
	}
	public boolean execute(Game game) {
		
		return false;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords[0].toLowerCase().equals("str")||commandWords[0].toLowerCase().equals("stringify")) {
			command = new StringifyCommand();
		}
		return command;	
	}

}

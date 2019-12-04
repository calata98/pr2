package command;

import game.Game;

public class StringifyCommand extends Command {

	public StringifyCommand() {
		super("Stringify","Stringify","List","Prints the list of available ships. ");
	}
	public boolean execute(Game game) {
		
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords.length == 1 && commandWords[0].toLowerCase().equals("stringify")) {
			command = new StringifyCommand();
		}
		return command;	
	}

}

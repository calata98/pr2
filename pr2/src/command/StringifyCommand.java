package command;

import Printers.PrinterTypes;
import game.Game;

public class StringifyCommand extends Command {

	public StringifyCommand() {
		super("Stringify","Stringify","Stringify","Prints the game stringified. ");
	}
	public boolean execute(Game game) {
		game.setPrinter(PrinterTypes.STRINGIFIER);
		game.setUpdate(false);
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

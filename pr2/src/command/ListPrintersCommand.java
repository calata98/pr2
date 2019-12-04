package command;

import exceptions.CommandParseException;
import game.Game;

public class ListPrintersCommand extends Command {
	public ListPrintersCommand() {
		super("ListPrinters","ListPrinters","List Printers","Prints the list of available printers. ");
	}
	public boolean execute(Game game) {
		System.out.println(game.getPrinter().getObject().helpText());
		game.setUpdate(false);
		return true;
	}
	public Command parse(String[] commandWords)throws CommandParseException{
		Command command=null;
		if(commandWords.length == 1 && commandWords[0].toLowerCase().equals("listprinters")){
			command = new ListPrintersCommand();
		}
		return command;	
	}
}

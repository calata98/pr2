package command;

import game.Game;

public class ListCommand extends Command {
	public ListCommand() {
		super("List","l","List","Prints the list of available ships. ");
	}
	public boolean execute(Game game) {
		game.setUpdate(false);
		System.out.println(game.list());
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords[0].toLowerCase().equals("l")||commandWords[0].toLowerCase().equals("list")) {
			command = new ListCommand();
		}
		return command;	
	}
}
package command;

import game.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("Reset","r","Reset","Starts a new game.");
	}
	public boolean execute(Game game) {
		game.reset();
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords[0].toLowerCase().equals("r")||commandWords[0].toLowerCase().equals("reset")) {
			command = new ResetCommand();
		}
		return command;	
	}
}
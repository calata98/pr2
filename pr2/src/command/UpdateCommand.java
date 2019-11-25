package command;

import game.Game;

public class UpdateCommand extends Command {

	public UpdateCommand() {
		super("Update","u","Update","Skips one cycle.");
	}
	public boolean execute(Game game) {	
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		if(commandWords[0].toLowerCase().equals("")||commandWords[0].toLowerCase().equals("n")||commandWords[0].toLowerCase().equals("none")) {
			command = new UpdateCommand();
		}
		return command;	
	}
}
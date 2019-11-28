package command;

import game.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("Shockwave","w","Shockwave","UCM-Ship releases a shock wave.");
	}
	public boolean execute(Game game) {
		game.shockWave();
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords[0].toLowerCase().equals("w")||commandWords[0].toLowerCase().equals("shockwave")) {
			command = new ShockwaveCommand();
		}
		return command;	
	}
}
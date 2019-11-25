package command;

import game.Game;

public class ShootCommand extends Command {

		public ShootCommand() {
			super("Shoot","s","Shoot","UCM-Ship launches a missile.");
		}
		public boolean execute(Game game) {	
				game.playerShoot();	
			return true;
		}
		public Command parse(String[] commandWords) {
			Command command=null;
			if(commandWords[0].toLowerCase().equals("shoot")||commandWords[0].toLowerCase().equals("s")) {
				command = new ShootCommand();
			}
			return command;	
		}
}
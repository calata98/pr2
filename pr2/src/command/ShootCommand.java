package command;

import exceptions.CommandExecuteException;
import game.Game;

public class ShootCommand extends Command {

		private boolean supermisil;

		public ShootCommand() {

			super("Shoot","s","Shoot","UCM-Ship launches a missile.");

		}
		public ShootCommand(boolean supermisil) {

			super("Shoot","s","Shoot","UCM-Ship launches a missile.");

			this.supermisil = supermisil;
		}
		public boolean execute(Game game) throws CommandExecuteException{	

			return game.shootMissile(supermisil);
		}

		public Command parse(String[] commandWords) {

			Command command=null;

			if(commandWords.length == 1 && (commandWords[0].toLowerCase().equals("shoot")||commandWords[0].toLowerCase().equals("s"))) {

				command = new ShootCommand();
			}else {

				if( commandWords.length == 2 && (commandWords[0].toLowerCase().equals("shoot")||commandWords[0].toLowerCase().equals("s")) && commandWords[1].toLowerCase().equals("supermisil")) {

					command = new ShootCommand(true);
				}
			}
			return command;	

		}

}
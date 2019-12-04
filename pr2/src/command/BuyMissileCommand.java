package command;

import exceptions.CommandExecuteException;
import game.Game;


public class BuyMissileCommand extends Command {
		
	public BuyMissileCommand() {
			super("BuyM", "supermisil","Buy Missile","if you have 20 points you can buy a supermissile that deals 2 of damage by that price.");
		}
	public boolean execute(Game game) throws CommandExecuteException {
		game.setUpdate(false);
		if(!game.enableMissile()) {
			throw new CommandExecuteException("Failed to buy a supermissile, you don't have 20 points");
		}
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords.length == 1 && commandWords[0].toLowerCase().equals("supermisil")) {
			command = new BuyMissileCommand();
		}
		return command;	
	}
}



package command;

import game.Game;


public class BuyMissileCommand extends Command {
		
	public BuyMissileCommand() {
			super("BuyM", "supermisil","Buy Missile","if you have 20 points you can buy a supermissile that deals 2 of damage by that price.");
		}
	public boolean execute(Game game) {
		game.setUpdate(false);
		return game.enableMissile();
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords.length == 1 && commandWords[0].toLowerCase().equals("supermisil")) {
			command = new BuyMissileCommand();
		}
		return command;	
	}
}



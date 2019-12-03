package command;

import game.Game;


public class BuyMissileCommand extends Command {
		
	public BuyMissileCommand() {
			super("BuyM", "bm","Buy Missile","if you have 20 points you can buy a supermissile that deals 2 of damage by that price.");
		}
	public boolean execute(Game game) {
		game.enableMissile();
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		
		if(commandWords[0].toLowerCase().equals("buym")||commandWords[0].toLowerCase().equals("bm")) {
			command = new BuyMissileCommand();
		}
		return command;	
	}
}



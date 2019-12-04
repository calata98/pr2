package Printers;

import game.Game;
import interfaces.GamePrinter;

public class Stringifier implements GamePrinter{

	
	
	
	
	@Override
	public String toString(Game game) {
		String str = "� Space Invaders v2.0 � \n";
		str += "\n";
		str += "G;" + game.getCurrentCycle() + "\n";
		str += "L;" + game.getLevel() + "\n";
		str += game.getStringifyText();
		return str;
	}

	@Override
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helpText() {
		// TODO Auto-generated method stub
		return null;
	}

}

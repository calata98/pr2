package interfaces;

import game.Game;

public interface GamePrinter {
	

	String toString(Game game);
	public GamePrinter parse(String name);
	public String helpText();
	
}

package game;


import java.util.Random;

import controller.Controller;
import game.Game;
import game.Level;

public class Main {

	public static void main(String[] args) {
		try {
		Random rand;
		Level level = Level.parse(args[0]);
		if(args.length>2) {
			throw new ArrayIndexOutOfBoundsException();	
		}
		
		if(args.length ==2) {
			rand = new Random(Integer.parseInt(args[1]));
		}else {
			rand = new Random();
		}
		if(level == null) {
			throw new NullPointerException();
		}
		
		Game miGame = new Game(level,rand);
		Controller miController = new Controller(miGame);
		miController.run();

	}catch(NumberFormatException e) {
		System.err.println("\"Usage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
	
	}catch(ArrayIndexOutOfBoundsException e) {
		System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]");
		
	}catch(NullPointerException e) {
		System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
		
	}
	}
	
}



package game;


import java.util.Random;

import controller.Controller;
import game.Game;
import game.Level;

public class Main {

	public static void main(String[] args) {
		Random rand;
		Level level = Level.parse(args[0]);
		if(args.length > 1) {
			rand = new Random(Integer.parseInt(args[1]));
		}else {
			rand = new Random();
		}
		
		Game miGame = new Game(level,rand);
		Controller miController = new Controller(miGame);
		miController.run();
		
	}
	
}



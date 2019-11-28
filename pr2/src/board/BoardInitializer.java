package board;

import game.Game;
import game.Level;
import objects.DestroyerAlien;
import objects.Ovni;
import objects.RegularAlien;

public class BoardInitializer {

	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	private void initializeOvni () {
		board.add(new Ovni(game,0,8,1));
	}

	private void initializeRegularAliens () {
		for(int i = 0; i < level.getNumRegularAliens(); i++) {
			if(level.getNumRegularAliensPerRow() % i == 0) {
				
			}
			board.add(new RegularAlien());
		}
	}
	
	private void initializeDestroyerAliens() {
		for(int i = 0; i < level.getNumDestroyerAliens(); i++) {
			if(level.getNumDestroyerAliensPerRow() % i == 0) {
				
			}
			board.add(new DestroyerAlien());
		}
	}
	
}

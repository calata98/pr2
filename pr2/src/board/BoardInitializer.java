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
	private int filaI;
	
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
		int columnaI = 3;
		filaI = 1;
		for(int i = 0; i < level.getNumRegularAliens(); i++) {
			board.add(new RegularAlien(game,filaI,columnaI,2));
			if(i != 0 && (i + 1) % level.getNumRegularAliensPerRow() == 0) {
				filaI++;
				columnaI = 2;
			}
			columnaI++;
		}
	}
	
	private void initializeDestroyerAliens() {
		int columnaI = 3;
		for(int i = 0; i < level.getNumDestroyerAliens(); i++) {
			if(level.getNumDestroyerAliens() > 2) {
				board.add(new DestroyerAlien(game,filaI,columnaI,1));
			}else {
				board.add(new DestroyerAlien(game,filaI,columnaI + 1,1));
			}
			
			columnaI++;
		}
	}
	
}

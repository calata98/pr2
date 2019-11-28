package objects;

import game.Game;

public abstract class EnemyShip extends Ship{

	public EnemyShip() {
		
	}
	
	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	

}

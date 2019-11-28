package objects;

import game.Game;

public abstract class Ship extends GameObject {

	public Ship () {
		
	}
	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
}

package objects;

import game.Game;

public class DestroyerAlien extends AlienShip{

	public DestroyerAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	
	
	

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "D[" + this.live + "]";
	}

	
	
	
	

}

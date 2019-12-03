package objects;

import game.Game;

public class ExplosiveAlien extends RegularAlien {

	public ExplosiveAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		
	}
	
	public ExplosiveAlien() {
		numNaves++;
		navesPorMover++;
	}

	@Override
	public void computerAction() {

		

	}


	@Override
	public String toString() {
		return "E[" + live + "]";
	}
	
	private void explosion() {
		
	}

}

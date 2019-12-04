package objects;

import game.Game;

public class ExplosiveAlien extends RegularAlien {

	private boolean exploded;
	
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
	public void onDelete() {
		numNaves--;
		navesPorMover--;
		if(!exploded) {
			game.explosion(x, y);
			exploded = true;
		}
	}
	
	@Override
	public String getStringifyText() {
		return "E;" + x + ";" + y + ";" + live + ";"+ (game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell()) + ";" + dir;
	}


	@Override
	public String toString() {
		return "E[" + live + "]";
	}

}

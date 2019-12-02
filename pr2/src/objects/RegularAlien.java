package objects;

import game.Game;

public class RegularAlien extends AlienShip{

	public RegularAlien() {
		
	}
	
	
	public RegularAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "R[" + this.live + "]";
	}
	

	
	@Override
	public void computerAction() {
		if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
				move();
		}
		
	}

}

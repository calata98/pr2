package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class RegularAlien extends AlienShip implements IExecuteRandomActions{

	public RegularAlien() {
		
	}
	
	
	public RegularAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void onDelete() {

		allDead = true;
		
	}

	@Override
	public String toString() {
		return "R[" + this.live + "]";
	}
	

	
	@Override
	public void computerAction() {
		allDead = false;
		
		
		if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
				move();
		}
		
		
	}

}

package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions{

	
	private Bomb bomba;
	
	public DestroyerAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	
	
	

	@Override
	public void onDelete() {
		allDead = true;
	}

	@Override
	public String toString() {
		return "D[" + this.live + "]";
	}
	
	@Override
	public void computerAction() {
		allDead = false;
		
		if(bomba != null && !game.isOnBoard(bomba.x, bomba.y)) {
			game.removeObject(bomba);
			bomba = null;
		}
		
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && bomba == null) {
			bomba = new Bomb(game,x + 1,y,1);
			game.addObject(bomba);
		}
		
		if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
				move();
		}
		
	}
	
	
	
	
	

}

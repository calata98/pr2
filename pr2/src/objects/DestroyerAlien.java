package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions{

	
	private Bomb bomba;
	
	public DestroyerAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		points = 10;
	}
	
	@Override
	public String toString() {
		return "D[" + this.live + "]";
	}
	
	@Override
	public void computerAction() {
		
		explodeCreated = false;
		if(bomba != null && (!game.isOnBoard(bomba.x, bomba.y) || !bomba.isAlive())) {
			game.removeObject(bomba);
			bomba = null;
		}
		
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && bomba == null) {
			bomba = new Bomb(game,x,y,1);
			game.addObject(bomba);
		}
		
	}
	
	@Override
	public String list() {
		return "[D]estroyer ship: Points: " + points + " -  Harm: 1 - Shield: " + live;
	}

	@Override
	public String getStringifyText() {
		return "D;" + x + ";" + y + ";" + live + ";"+ (game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell()) + ";" + dir;
	}

}

package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class RegularAlien extends AlienShip implements IExecuteRandomActions{

	
	
	public RegularAlien() {
		points = 5;
	}
	
	
	public RegularAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		points = 5;
	}

	@Override
	public String toString() {
		return "R[" + this.live + "]";
	}
	

	
	@Override
	public void computerAction() {
		allDead = false;
		
		if(IExecuteRandomActions.canGenerateRandomExplosiveAlien(game)) {
			explodeCreated = true;
			game.removeObject(this);
			ExplosiveAlien aux = new ExplosiveAlien();
			aux.setGame(game);
			aux.setX(x);
			aux.setY(y);
			aux.setLive(2);
			game.addObject(aux);
		}else {
			explodeCreated = false;
		}

		
	}

	
	protected void setX(int x) {
		this.x = x;
	}
	
	protected void setY(int y) {
		this.y = y;
	}
	
	protected void setGame(Game game) {
		this.game = game;
		game.setNumNaves(numNaves);
	}
	
	protected void setLive(int live) {
		this.live = live;
	}
	
	@Override
	public String list() {
		return "[R]egular ship: Points: " + points + " -  Harm: 0 - Shield: " + live;
	}
	
}

package objects;

import game.Game;
import interfaces.IPlayerController;

public class UCMShip extends Ship{

	public UCMShip() {
		
	}
	
	public UCMShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		
	}

	@Override
	public String toString() {
		if(this.isAlive()) {
			return "^___^";
		}else {
			return "!xx!";
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.live -= 1;
		return true;
	}
	
	
	
}

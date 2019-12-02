package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	private boolean enabled;
	private int points = 25;
	
	public Ovni() {
		
	}
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.enabled = false;
	}

	public boolean getEnabled() {
		return enabled;
	}
	
	@Override
	public void move() {
		this.y -= 1;
	}
	
	@Override
	public void computerAction() {
		
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && !enabled) {
			enabled = true;
		}

		if(enabled) {
			move();
		}
	}

	@Override
	public void onDelete() {
		this.enabled = false;
	}

	@Override
	public String toString() {
		if(enabled) {
			return "O[" + this.live + "]";
		}else {
			return "";
		}
	}
	
	public int getPoints() {
		return points;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

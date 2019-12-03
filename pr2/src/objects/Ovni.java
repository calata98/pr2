package objects;

import game.Game;
import interfaces.IExecuteRandomActions;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	private boolean enabled;
	protected int points = 25;
	
	public Ovni() {
		
	}
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.enabled = false;
	}
	
	@Override
	public void move() {
		this.y -= 1;
	}
	
	@Override
	public void computerAction() {
		
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && !enabled) {
			enabled = true;
			live = 1;
		}
		if(enabled) {
			move();
		}
		
		if(this.isOut()) {
			enabled = false;
			y = 9;
		}
		
		
	}

	@Override
	public void onDelete() {
		this.enabled = false;
		live = 1;
		game.enableShockWave();
	}

	@Override
	public String toString() {
		if(enabled) {
			return "O[" + this.live + "]";
		}else {
			return "";
		}
	}
	
	@Override
	public String list() {
		return "[O]vni: Points: " + points + " -  Harm: 0 - Shield: " + live;
	}

	@Override
	public void update() {
		computerAction();
	}

}

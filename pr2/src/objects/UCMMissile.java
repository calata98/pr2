package objects;

import game.Game;

public class UCMMissile extends Weapon{
	
	public UCMMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
	}

	@Override
	public void onDelete() {

		
		
	}

	@Override
	public void move() {
		x -= 1;
		if(x < 0) {
			live = 0;
		}
	}

	@Override
	public String toString() {
		return "oo";
	}

	@Override
	public void update() {
		move();
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		return true;
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(other != null && this.isAlive() && other.isAlive()) {
				if(other.receiveMissileAttack(live)) {
					other.getDamage(live);
					live--;
				}
			return true;
		}
		return false;
	}

	@Override
	public String list() {
		return null;
	}

	@Override
	public String getStringifyText() {
		return "M;" + x + ";" + y;
	}
}

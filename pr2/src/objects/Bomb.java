package objects;

import game.Game;

public class Bomb extends Weapon {
	
	public Bomb(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
	public boolean receiveMissileAttack(int dmg) {
		return true;
	}

	@Override
	public void onDelete() {

		
		
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(other != null && this.isAlive() && other.isAlive()) {
				if(other.receiveBombAttack(live)) {
					other.getDamage(live);
					live--;
				}
			return true;
		}
		return false;
	}

	@Override
	public void move() {
		x += 1;
	}

	@Override
	public String toString() {
		return ".";
	}
	@Override
	public void update() {
		move();
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText() {
		return "B;" + x + ";" + y;
	}
	
	@Override
	public String getStringifyText() {
		return null;
	}

}

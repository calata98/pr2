package objects;

import game.Game;

public class Supermissile extends UCMMissile {

	public Supermissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}
	
	private final int damage = 2;

	@Override
	public String toString() {
		return "OO";
	}

	@Override
	public String list() {
		return null;
	}

	@Override
	public void onDelete() {
		game.deleteSuperMisil();
	}
	
	@Override
	public String getStringifyText() {
		return "X;" + x + ";" + y;
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(other != null && this.isAlive() && other.isAlive()) {
				if(other.receiveMissileAttack(damage)) {
					other.getDamage(damage);
					live -= damage;
				}
			return true;
		}
		return false;
	}
	
}

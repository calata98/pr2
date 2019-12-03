package objects;

import game.Game;

public abstract class Weapon extends GameObject {

	public Weapon(Game game, int x, int y,int live) {
		super(game, x, y,live);
	}

	@Override
	public boolean performAttack(GameObject other) {
		
		if(other != null && this.isAlive() && other.isAlive()) {
				if(this instanceof Bomb && other.receiveBombAttack(live)) {
					other.getDamage(live);
					live--;
				}
				if(this instanceof UCMMissile && other.receiveMissileAttack(live)) {
					other.getDamage(live);
					live--;
				}
				
				return true;
		}
		
		return false;
	}

}

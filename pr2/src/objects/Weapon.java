package objects;

import game.Game;

public abstract class Weapon extends GameObject {

	public Weapon(Game game, int x, int y,int live) {
		super(game, x, y,live);
	}

	@Override
	public boolean performAttack(GameObject other) {
		
		if(other != null && this.isAlive() && other.isAlive()) {
			if(other.isOnPosition(x, y)) {
				if(this instanceof Bomb) {
					other.receiveBombAttack(live);
				}
				if(this instanceof UCMMissile ) {
					other.receiveMissileAttack(live);
				}
				live -= 1;
				return true;
			}
		}
		
		return false;
	}

}

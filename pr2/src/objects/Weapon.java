package objects;

import game.Game;

public abstract class Weapon extends GameObject {

	public Weapon(Game game, int x, int y,int live) {
		super(game, x, y,live);
	}

	@Override
	public boolean performAttack(GameObject other) {
		
		if(this.isAlive() && other.isAlive()) {
			if(other.isOnPosition(x, y)) {
				
			}
		}
		
		return true;
	}
	
	
	public void weaponAttack(GameObject object) {
		
		
		
	}

}

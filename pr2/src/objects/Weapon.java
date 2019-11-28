package objects;


public abstract class Weapon extends GameObject {

	

	@Override
	public boolean performAttack(GameObject other) {
		
		if(this.isAlive() && other.isAlive()) {
			if(other.isOnPosition(x, y)) {
				
			}
		}
		
		return true;
	}
	

}

package objects;

import game.Game;

public class Shockwave extends Weapon{

	public Shockwave(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(game.getShockWave()) {
			return true;
		}
		
		return false;
	}

	@Override
	public String list() {
		return null;
	}

}

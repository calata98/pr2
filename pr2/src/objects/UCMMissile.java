package objects;

import game.Game;

public class UCMMissile extends Weapon{
	
	public UCMMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		move();
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		x -= 1;
	}

	@Override
	public String toString() {
		return "oo";
	}

	@Override
	public void update() {

		
		
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.live -= 1;
		return true;
	}
}

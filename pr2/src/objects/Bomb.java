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
		live -= 1;
		return true;
	}

	@Override
	public void onDelete() {

		
		
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

}

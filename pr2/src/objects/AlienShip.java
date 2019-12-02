package objects;

import game.Game;

public abstract class AlienShip extends EnemyShip{
	
	private static Move dir;
	private Move dirAnt;
	private static boolean tierra;
	
	public AlienShip() {
		
	}
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		dir = Move.IZQ;
		dirAnt = Move.IZQ;
		tierra = false;
	}
	
	@Override
	public void move() {
		
		switch(dir) {
			case IZQ:
				y -= 1;
				break;
			case DCHA:
				y += 1;
				break;
			case ABAJO:
				x += 1;
				break;
		}
		if(x == game.DIM_X) {
			tierra = true;
		}
		dirAnt = dir;
	}
	
	public boolean pared() {
			return y == 0 || y == 8;
	}
	
	
	@Override
	public void update() {
		
		if(pared() && dirAnt != Move.ABAJO) {
			dir = Move.ABAJO;
		}else {
			if(pared()) {
				if(y == 0) {
					dir = Move.DCHA;
				}else {
					dir = Move.IZQ;
				}
			}
		}
		
	}
	
	public boolean receiveMissileAttack(int dmg) {
		getDamage(dmg);

		return true;
	}
	
	public static boolean allDead() {
		
		
		
		return false;
	}
	
	public static boolean haveLanded() {
		return tierra;
	}
	
}

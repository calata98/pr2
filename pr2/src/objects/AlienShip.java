package objects;

import game.Game;

public abstract class AlienShip extends EnemyShip{
	
	private int dir;
	
	public AlienShip() {
		
	}
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		dir = 1;
	}
	
	@Override
	public void move() {
		
		switch(dir) {
			case 0:
				x += 1;
				break;
			case 1:
				y -= 1;
				break;
			case 2:
				x += 1;
				break;
			case 3:
				y += 1;
				break;
				
		}
		
	}
	
	@Override
	public void computerAction() {
		
		if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			move();
		}
		
	}
	
	public boolean pared() {
		return y == 0 || y == 8;
	}
	
	public void swapDir() {
		
		if(dir != 3) {
			dir++;
		}else {
			dir = 0;
		}
		
	}
	
	public static boolean allDead() {
		
		
		
		return true;
	}
	
	public static boolean haveLanded() {
		
		
		
		return true;
	}
	
}

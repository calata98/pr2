package objects;

import game.Game;

public abstract class AlienShip extends EnemyShip{
	
	private static Move dir;
	private static Move dirAnt;
	private static boolean abajo;
	private static boolean tierra;
	protected static boolean allDead;
	private static int navesPorMover;
	private int numNaves;
	
	public AlienShip() {
		
	}
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		dir = Move.DCHA;
		dirAnt = Move.DCHA;
		abajo = false;
		tierra = false;
		numNaves = game.getLevel().getNumDestroyerAliens() + game.getLevel().getNumRegularAliens();
		navesPorMover = numNaves;
	}
	
	@Override
	public void move() {
		switch(dir) {
			case ABAJO:
				x += 1;
				break;
			case IZQ:
				y -= 1;
				break;
			case DCHA:
				y += 1;
				break;
		}
		if(x == game.DIM_X) {
			tierra = true;
		}
	}
	
	public boolean pared() {
			return y == 0 || y == 8;
	}
	


	@Override
	public void onDelete() {
		numNaves--;
	}
	
	@Override
	public void update() {
		
		if(navesPorMover == numNaves) {
			if(abajo) {
				dirAnt = dir;
				dir = Move.ABAJO; 
			}
		}
		
		
		if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			navesPorMover--;
			move();
		}
		
		
		if(pared() && !abajo && dir != Move.ABAJO) {
			abajo = true;
		}
		
		if(navesPorMover == 0) {
			if(abajo && dir == Move.ABAJO) {
				abajo = !abajo;
				if(dirAnt == Move.DCHA){
					dir = Move.IZQ;
				}else {
					dir = Move.DCHA;
				}
				dirAnt = Move.ABAJO;
			}
			navesPorMover = numNaves;
		}
		
		computerAction();
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

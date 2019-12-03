package objects;

import game.Game;

public abstract class AlienShip extends EnemyShip{
	
	protected static boolean izq;
	protected static String estado;
	protected static boolean dirCambiada;
	protected static boolean tierra;
	protected static boolean allDead;
	protected static int navesPorMover;
	protected static int numNaves;
	
	public AlienShip() {
		
	}
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		tierra = false;
		numNaves = game.getLevel().getNumDestroyerAliens() + game.getLevel().getNumRegularAliens();
		izq = true;
		estado = "normal";
		navesPorMover = numNaves;
	}
	
	@Override
	public void move() {
		if(izq) {
			y -= 1;
		}else {
			y += 1;
		}
	}
	
	public boolean pared() {
			return y == 0 || y == 8;
	}
	
	public void moveAbajo() {

		x += 1;
		
		if(x == game.DIM_X) {
			tierra = true;
		}
	}

	@Override
	public void onDelete() {
		numNaves--;
		navesPorMover--;
		game.setNumNaves(numNaves);
	}
	
	@Override
	public void update() {
		
		navesPorMover--;
		
		switch(AlienShip.estado) {
		
		case "normal":
			if(canMove()) {
				move();
			}
			if(pared()) {
				estado = "llegadaPared";
			}
			break;
		
		case "llegadaPared":
			if(canMove()) {
				move();
			}
			if(navesPorMover == 0) {
				estado = "moverAbajo";
			}
			break;
			
		case "moverAbajo":
			moveAbajo();
			if(navesPorMover == 0) {
				estado = "salidaPared";
				dirCambiada = false;
			}
			break;	
			
		case "salidaPared":
			if(!dirCambiada) {
				izq = !izq;
				dirCambiada = true;
			}
			if(canMove()) {
				move();
			}
			
			if(navesPorMover == 0) {
				estado = "normal";
			}
			break;
		}
		
		if(navesPorMover == 0) {
			navesPorMover = numNaves;
		}
		computerAction();
		
	}
	
	public boolean canMove() { 
		return game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell()  == 0;
	}
	
	
	@Override
	public boolean receiveShockWaveAttack(int dmg) {
		return true;
	}
	
	public static boolean allDead() {
		return numNaves <= 0;
	}
	
	public static boolean haveLanded() {
		return tierra;
	}
	
}

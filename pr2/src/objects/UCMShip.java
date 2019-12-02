package objects;

import game.Game;
import interfaces.IPlayerController;

public class UCMShip extends Ship{
	
	private String direccion;
	private int numCeldas;
	private UCMMissile misil;

	public UCMShip() {
		
	}
	
	public UCMShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	
	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		if(direccion.equals("right")) {
			y += numCeldas;
		}else {
			y -= numCeldas;
		}
	}
	
	public boolean shoot() {
		if(misil == null) {
			misil = new UCMMissile(game,x,y,1);
			game.addObject(misil);
			return true;
		}
		
		return false;
	}
	

	@Override
	public String toString() {
		if(this.isAlive()) {
			return "^___^";
		}else {
			return "!xx!";
		}
	}

	@Override
	public void computerAction() {

		if(AlienShip.haveLanded()) {
			live = 0;
		}
		
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.live -= 1;
		return true;
	}
	
	public void setMove(String dir, int num) {
		this.direccion = dir;
		this.numCeldas = num;
	}

	@Override
	public void update() {
		
		if(misil.x == 0) {
			misil = null;
			game.removeObject(misil);
		}
		
	}
	
	
	
}

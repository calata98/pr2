package objects;

import exceptions.CommandExecuteException;
import game.Game;
import interfaces.IPlayerController;

public class UCMShip extends Ship{
	
	private String direccion;
	private int numCeldas;
	private UCMMissile misil;
	private int points;

	public UCMShip() {
		
	}
	
	public UCMShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	
	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	public void moveUCM () throws CommandExecuteException {
		if ((direccion.equals("left") && (y - numCeldas) >= 0) || (direccion.equals("right") && (y + numCeldas) <= Game.DIM_Y)) {
			move();
		}else {
			throw new CommandExecuteException("fuera tablero");
		}
	}
	
	@Override
	public void move() {
		if(direccion.equals("right")) {
			y += numCeldas;
		}else {
			y -= numCeldas;
		}
	}
	
	public boolean shoot(boolean supermisil) throws CommandExecuteException {
		if(misil != null && !misil.isAlive()) {
			misil = null;
		}
		if(misil == null) {
			if(supermisil) {
				misil = new Supermissile(game,x,y,1);
			}else {
				misil = new UCMMissile(game,x,y,1);
			}
			
			game.addObject(misil);
			return true;
		}
		throw new CommandExecuteException("El misil sigue en el tablero");
	}
	

	@Override
	public String toString() {
		if(this.isAlive() && !AlienShip.haveLanded()) {
			return "^___^";
		}else {
			return "!xx!";
		}
	}

	@Override
	public void computerAction() {

		if(misil != null && !misil.isAlive()) {
			misil = null;
			game.removeObject(misil);
		}
		
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		return true;
	}
	
	public void setMove(String dir, int num) {
		this.direccion = dir;
		this.numCeldas = num;
	}

	@Override
	public void update() {
		if(misil != null && (!game.isOnBoard(x,y) || !misil.isAlive())) {
			misil = null;
			game.removeObject(misil);
		}
		
	}
	
	public void receivePoints(int points) {
		this.points += points;
	}
	
	public void deletePoints(int points) {
		this.points -= points;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String list() {
		return "^___^:  Harm: 1 - Shield: " + live;
	}

	@Override
	public String getStringifyText() {
		return "P;" + x + ";" + y + ";" + live + ";" + points;
	}
	
	
}

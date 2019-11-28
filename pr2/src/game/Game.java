package game;

import java.util.Random;

import board.BoardInitializer;
import board.GameObjectBoard;
import objects.AlienShip;
import objects.GameObject;
import objects.UCMShip;
import interfaces.IPlayerController;

public class Game implements IPlayerController{
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;

	private int currentCycle;
	private Random rand;
	private Level level;
	private int points;

	GameObjectBoard board;

	private UCMShip player;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X - 1, DIM_Y / 2, 3);
		board.add(player);
	}

	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int x, int y) {
		return board.toString(x,y);
	}
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}
	
	private boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	

	public boolean isOnBoard(int x, int y) {
		return (x <= DIM_X && x >= 0 || y <= DIM_Y && y >= 0) ;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		String str = "";
		
		
		str += "Life: " + player.getLive() + " \n";
		str += "Number of cycles: " + currentCycle + " \n";
		str += "Points: " + points + " \n";
		str += "Remaining aliens: "/* + (destroyerShipList.getNumD() + regularShipList.getNumR()) */ + " \n";	
		str += "ShockWave: ";
		
			/*if(shockwave) {
				str += "Si";
			}else {
				str += "No";
			}*/
			
		
		return str;
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}

	@Override
	public boolean move(int numCells) {
		player.move();
		return false;
	}

	@Override
	public boolean shootMissile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shockWave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableShockWave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}
	
	// TODO implementar los metodos del interfaz IPlayerController
}

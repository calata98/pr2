package game;

import java.util.Random;

import board.BoardInitializer;
import board.GameObjectBoard;
import objects.AlienShip;
import objects.GameObject;
import objects.Shockwave;
import objects.UCMShip;
import interfaces.IPlayerController;

public class Game implements IPlayerController{
	public final static int DIM_X = 7;
	public final static int DIM_Y = 8;
	
	public static boolean shockwave;
	
	private int numNaves;

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
		player = new UCMShip(this, DIM_X, DIM_Y / 2, 3);
		board.add(player);
		shockwave = false;
		numNaves = level.getNumDestroyerAliens() + level.getNumRegularAliens();
		doExit = false;
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
	
	public void removeObject(GameObject object) {
		board.remove(object);
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
		board.update();
		currentCycle += 1;
	}
	

	public boolean isOnBoard(int x, int y) {
		return (x <= DIM_X && x >= 0 && y <= DIM_Y && y >= 0) ;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		String str = "";
		
		
		str += "Life: " + player.getLive() + " \n";
		str += "Number of cycles: " + currentCycle + " \n";
		str += "Points: " + points + " \n";
		str += "Remaining aliens: " + numNaves + " \n";	
		str += "ShockWave: ";
		
			
			
		
		return str;
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}

	@Override
	public boolean move(String direccion,int numCells) {
		player.setMove(direccion, numCells);
		player.move();
		return true;
	}

	@Override
	public boolean shootMissile() {
		return player.shoot();
	}

	@Override
	public boolean shockWave() {
		if(shockwave) {
			board.shockwave();
		}
		
		return shockwave;
	}

	@Override
	public void receivePoints(int points) {
		
	}

	@Override
	public void enableShockWave() {
		addObject(new Shockwave(this,0,0,1));
		shockwave = true;
	}

	@Override
	public void enableMissile() {

		
		
	}
	
	public void setNumNaves(int numNaves) {
		this.numNaves = numNaves;
	}
	
	public int getCurrentCycle() {
		return currentCycle;
	}
	
	
	
	// TODO implementar los metodos del interfaz IPlayerController
}

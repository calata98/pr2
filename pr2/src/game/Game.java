package game;

import java.util.Random;

import Printers.PrinterTypes;
import board.BoardInitializer;
import board.GameObjectBoard;
import objects.AlienShip;
import objects.GameObject;
import objects.UCMShip;
import interfaces.IPlayerController;

public class Game implements IPlayerController{
	public final static int DIM_X = 7;
	public final static int DIM_Y = 8;
	
	private static boolean shockwave;
	private int numSuperMisiles;
	private boolean superMisilComprado;
	
	private int numNaves;

	private int currentCycle;
	private Random rand;
	private Level level;
	private PrinterTypes printer;
	private boolean update;

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
		update = true;
		printer = PrinterTypes.BOARDPRINTER;
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
		if(update) {
			board.update();
			currentCycle += 1;
			System.out.println(infoToString());
		}
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
		str += "Points: " + player.getPoints() + " \n";
		str += "Remaining aliens: " + numNaves + " \n";	
		str += "ShockWave: ";
		
			if(shockwave) {
				str += "Si\n";
			}else {
				str += "No\n";
			}
		str += "SuperMissiles : " + numSuperMisiles;
			
			
		
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
		return player.moveUCM();
	}
	


	@Override
	public boolean shootMissile(boolean supermisil) {
		if(supermisil && numSuperMisiles == 0) {
			return false;
		}else {
			return player.shoot(supermisil);
		}
	}

	@Override
	public boolean shockWave() {
		if(shockwave) {
			board.shockwave();
		}
		
		return shockwave;
	}
	
	public boolean getShockWave() {
		return shockwave;
	}

	@Override
	public void receivePoints(int points) {
		player.receivePoints(points);
	}

	@Override
	public void enableShockWave() {
		shockwave = true;
	}

	@Override
	public boolean enableMissile() {
		if(player.getPoints() >= 20) {
			superMisilComprado = true;
			numSuperMisiles++;
			return true;
		}
		return false;
	}
	
	public PrinterTypes getPrinter() {
		return printer;
	}

	public void setPrinter(PrinterTypes printer) {
		this.printer = printer;
	}

	public void explosion(int x, int y) {
		board.explosion(x, y);
	}
	
	public void deleteSuperMisil() {
		numSuperMisiles--;
	}
	
	public void setNumNaves(int numNaves) {
		this.numNaves = numNaves;
	}
	
	public int getCurrentObjectsLength() {
		return board.getCurrentObjectsLength();
	}
	
	public int getCurrentCycle() {
		return currentCycle;
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	public boolean getUpdate() {
		return update;
	}
	
	public String getStringifyText() {
		return  board.getStringifyText();
	}
	
	public String list() {
		return board.list();
	}
	
}

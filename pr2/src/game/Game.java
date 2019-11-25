package game;

import java.util.Random;

import board.GameObjectBoard;
import chars.Bomb;
import chars.DestroyerShip;
import chars.Ovni;
import chars.UCMShip;
import gameObject.AlienShip;
import gameObject.GameObject;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;

	private int currentCycle;
	private Random rand;
	private Level level;

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
		player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
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
	
	public String positionToString( /* coordinadas */ ) {
		return board.toString( /* coordinadas */ );

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
	

	public boolean isOnBoard( /* coordenadas */ ) {
		return /* condicion de rango sobre las coordenadas */ ;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		return /* cadena estado-juego para imprimir junto con el tablero */; 
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	// TODO implementar los metodos del interfaz IPlayerController
}

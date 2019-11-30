package interfaces;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move (String direccion, int numCells);
	public boolean shootMissile();
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	
}
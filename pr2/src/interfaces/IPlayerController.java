package interfaces;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move (String direccion, int numCells);
	public boolean shootMissile(boolean supermisil);
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public boolean enableMissile();
	
}
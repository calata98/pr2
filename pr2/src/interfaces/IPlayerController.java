package interfaces;

import exceptions.CommandExecuteException;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public void move (String direccion, int numCells) throws CommandExecuteException ;
	public boolean shootMissile(boolean supermisil) throws CommandExecuteException ;
	public boolean shockWave() throws CommandExecuteException ;
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile() throws CommandExecuteException;
	
}
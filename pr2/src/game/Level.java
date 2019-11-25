package game;

public enum Level {
	
	/*EASY, HARD, INSANE;
	
	private double fD; //Frecuencia disparo
	private double fO; //Frecuencia ovni
	private int velocidad; //Velocidad de movimiento
	private int numD;
	private int numR;	
	
	public void setNaves(Level level) {
		
		if(level == Level.EASY) {
			fD = 10;
			fO = 20;
			velocidad = 3;
			numD = 2;
			numR = 4;
		}
		
		if(level == Level.HARD) {
			fD = 30;
			fO = 20;
			velocidad = 2;
			numD = 2;
			numR = 8;
		}
		
		if(level == Level.INSANE) {
			fD = 50;
			fO = 10;
			velocidad = 1;
			numD = 4;
			numR = 8;
		}
		
		
	}

	public double getfD() {
		return fD;
	}

	public double getfO() {
		return fO;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getNumD() {
		return numD;
	}

	public int getNumR() {
		return numR;
	}*/
	
	EASY(4, 2, 0.2, 3, 0.5, 1), 
	HARD(8, 4, 0.3, 2, 0.2, 2),
	INSANE(12, 4, 0.5, 1, 0.1, 3);

	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private int numRowsOfRegularAliens;
	private double turnExplodeFrequency = 0.05; // actualmente no depende del nivel

	private Level(
			int numRegularAliens, 
			int numDestroyerAliens, 
			double shootFrequency, 
			int numCyclesToMoveOneCell, 
			double ovniFrequency, 
			int numRowsOfRegularAliens)
	{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
	}
	

	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}

	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	public double getOvniFrequency() { 
		return ovniFrequency;
	}
	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}
	
	public int getNumRegularAliensPerRow() {
		return numRegularAliens / numRowsOfRegularAliens;
	}
	
	public int  getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens(); 
	}
	
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
	    return EASY;
	}

	public double getTurnExplodeFrequency(){
		return turnExplodeFrequency;
	}

}






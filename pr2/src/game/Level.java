package game;

public enum Level {
	
	EASY, HARD, INSANE;
	
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
	}
	
	

}






package objects;

public enum Move {

	IZQ, DCHA, ABAJO;
	
	
	
	public static Move parse(String dir) {
		switch(dir) {
			case "IZQ":
				return Move.IZQ;
			case "DCHA":
				return Move.DCHA;
			case "ABAJO":
				return Move.ABAJO;
			default:
				return null;
		}
	}
}

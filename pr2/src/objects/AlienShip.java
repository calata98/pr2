package objects;

import game.Game;

public abstract class AlienShip extends EnemyShip{
	
	private String direccion;
	private String direccionAnt;
	
	public AlienShip() {
		
	}
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.direccion = "izq";
		this.direccionAnt = "izq";
	}
	
	@Override
	public void move() {
		switch(direccion) {
			case "izq":
				this.y -= 1;
				direccionAnt = "izq";
				break;
			case "dcha":
				this.y += 1;
				direccionAnt = "dcha";
				break;
			case "abajo":
				this.x += 1;
				
				if(direccionAnt.equals("izq")) {
					direccion = "dcha";
				}else {
					direccion = "izq";
				}
				direccionAnt = "abajo";
				
				break;
		}
		
		if(y == 0 || y == 9 && !direccionAnt.equals("abajo")) {
			this.direccion = "abajo";
		}
		
	}
	
	
	public static boolean allDead() {
		
		
		
		return true;
	}
	
	public static boolean haveLanded() {
		
		
		
		return true;
	}
	
}

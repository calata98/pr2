package objects;

import game.Game;

public class Ovni extends AlienShip{

	private boolean enabled;
	private int points = 25;
	
	public Ovni() {
		
	}
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.enabled = false;
	}

	public boolean getEnabled() {
		return enabled;
	}
	
	@Override
	public void move() {
		this.y -= 1;
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDelete() {
		this.enabled = false;
	}

	@Override
	public String toString() {
		return "O[" + this.live + "]";
	}
	
	public int getPoints() {
		return points;
	}

}

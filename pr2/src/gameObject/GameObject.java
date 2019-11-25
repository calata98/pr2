package gameObject;

import game.Game;
import interfaces.IAttack;

public abstract class GameObject implements IAttack {
	/*protected /* coordinadas ;*/
	protected int live;
	protected Game game;
	
	public GameObject( Game game, /* coordinadas iniciales , */int live) {
		/* almacenar coordinadas iniciales */
		this.game = game;
		this.live = live;
	}
	
	/* métodos que devuelven el valor de las coordinadas */

	public boolean isAlive() {
		return this.live > 0;
	}

	public int getLive() {
		return this.live;
	}
	
	public boolean isOnPosition( /* otras coordinadas */ ) {
		return /* coordinadas = otras coordinadas */ ;
	}

	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard( /* coordinadas */ );
	}

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
}

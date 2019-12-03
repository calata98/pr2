package board;

import objects.GameObject;
import objects.Ovni;
import objects.Shockwave;
import objects.UCMShip;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects = 1;
	
	
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject [30];
	}
	
	private int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) {
		for( int i = 0; i < objects.length; i++) {
			if(objects[i] == null) {
				objects[i] = object;
				break;
			}
		}
		currentObjects++;
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].isOnPosition(x, y)) {
				return objects[i];
			}
		}
		return null;
	}
	
	private int getIndex(int x, int y) {
		boolean found = false;
		int contador = 0;
		while(!found) {
			if(contador >= objects.length) {
				return -1;
			}
			if(objects[contador] != null && objects[contador].isOnPosition(x, y)) {
				found = true;
			}
			contador++;
		}
		return contador;
	}

	public void remove (GameObject object) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].equals(object)) {
				objects[i].onDelete();
				objects[i] = null;
				currentObjects--;
			}
		}
	}
	
	public void update() {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null) {
				checkAttacks(objects[i]);
				objects[i].update();
				checkAttacks(objects[i]);
			}
		}
		removeDead();
	}
	
	private void checkAttacks(GameObject object) {
		for(int i = 0; i < objects.length;i++) {
			if(objects[i] != null && objects[i] !=  object && objects[i].isOnPosition(object.getX(), object.getY())) {
				object.performAttack(objects[i]);
			}
		}
	}
	
	public void computerAction() {
		
		
	}
	
	private void removeDead() {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && !objects[i].isAlive()) {
				if(!(objects[i] instanceof UCMShip) && !(objects[i] instanceof Ovni)) {
					remove(objects[i]);
				}else {
					objects[i].onDelete();
				}
			}
		}
	}
	
	public void shockwave() {
		
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && !(objects[i] instanceof Shockwave) && objects[i].receiveShockWaveAttack(1)){
				objects[i].getDamage(1);
			}
		}
		
	}
	
	public String list() {
		String str = "";
		
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].list() != null) {
				str += objects[i].list();
				str += "\n";
			}
		}
		return str;
	}
	
	

	public String toString(int x, int y) {
		if(getObjectInPosition(x,y) != null) {
			return getObjectInPosition(x,y).toString();
		}else {
			return "";
		}
	}
	
}

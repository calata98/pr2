package board;

import objects.GameObject;
import objects.Ovni;
import objects.UCMShip;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;
	
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
				objects[i].update();
				checkAttacks(objects[i]);
				removeDead();
			}
		}
		
	}
	
	private void checkAttacks(GameObject object) {
			GameObject aux = getObjectInPosition(object.getX(), object.getY());
			if(aux != object) {
				object.performAttack(aux);
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

	public String toString(int x, int y) {
		if(getObjectInPosition(x,y) != null) {
			return getObjectInPosition(x,y).toString();
		}else {
			return "";
		}
	}
	
}

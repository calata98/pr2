package board;

import objects.GameObject;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		// TODO implement
	}
	
	/*private int getCurrentObjects () {
		// TODO implement
	}*/
	
	public void add (GameObject object) {
		boolean nulo = false;
		int contador = 0;
		while(!nulo) {
			if(objects[contador] == null) {
				nulo = true;
			}
			contador++;
		}
		objects[contador] = object;
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		boolean found = false;
		int contador = 0;
		while(!found) {
			if(objects[contador].isOnPosition(x, y)) {
				found = true;
			}
			contador++;
		}
		return objects[contador];
	}
	
	private int getIndex(int x, int y) {
		boolean found = false;
		int contador = 0;
		while(!found) {
			if(objects[contador].isOnPosition(x, y)) {
				found = true;
			}
			contador++;
		}
		return contador;
	}

	public void remove (GameObject object) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i].equals(object)) {
				objects[i] = null;
			}
		}
	}
	
	public void update() {
		// TODO implement
	}
	
	private void checkAttacks(GameObject object) {
		// TODO implement
	}
	
	public void computerAction() {
		// TODO implement
	}
	
	private void removeDead() {
		// TODO implement
	}

	public String toString(int x, int y) {
		return "";
	}
	
}

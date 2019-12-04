package board;

import objects.GameObject;
import objects.Ovni;
import objects.Shockwave;
import objects.UCMShip;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjectsLength = 35;
	
	
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject [currentObjectsLength];
	}
	
	public int getCurrentObjectsLength () {
		return currentObjectsLength;
	}
	
	public void add (GameObject object) {
		for( int i = 0; i < objects.length; i++) {
			if(objects[i] == null) {
				objects[i] = object;
				break;
			}
		}
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].isOnPosition(x, y)) {
				return objects[i];
			}
		}
		return null;
	}

	public void remove (GameObject object) {
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].equals(object)) {
				objects[i].onDelete();
				objects[i] = null;
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
	
	public void explosion(int x, int y) {
		if(getObjectInPosition(x, y - 1) != null) 
			getObjectInPosition(x, y - 1).getDamage(1);
		if(getObjectInPosition(x, y + 1) != null)
			getObjectInPosition(x, y + 1).getDamage(1);
		if(getObjectInPosition(x - 1 , y - 1) != null)
			getObjectInPosition(x - 1 , y - 1).getDamage(1);
		if(getObjectInPosition(x - 1, y) != null)
			getObjectInPosition(x - 1, y).getDamage(1);
		if(getObjectInPosition(x - 1, y + 1) != null)
			getObjectInPosition(x - 1, y + 1).getDamage(1);
		if(getObjectInPosition(x + 1, y + 1) != null)
			getObjectInPosition(x + 1, y + 1).getDamage(1);
		if(getObjectInPosition(x + 1, y) != null)
			getObjectInPosition(x + 1, y).getDamage(1);
		if(getObjectInPosition(x + 1, y - 1) != null)
			getObjectInPosition(x + 1, y - 1).getDamage(1);
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
	
	public String getStringifyText() {
		String str = "";
		for(int i = 0; i < objects.length; i++) {
			if(objects[i] != null && objects[i].getStringifyText() != null) {
				str += objects[i].getStringifyText() + "\n";
			}
		}
		
		return str;
	}

	public String toString(int x, int y) {
		removeDead();
		if(getObjectInPosition(x,y) != null) {
			return getObjectInPosition(x,y).toString();
		}else {
			return "";
		}
	}
	
}

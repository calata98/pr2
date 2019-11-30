package controller;

import java.util.Scanner;

import command.Command;
import command.CommandGenerator;
import game.Game;
import Printers.BoardPrinter;

public class Controller {

	private Game game;
	private boolean end = false;
	Scanner in;

	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
	}
	/*private void gameOver() {
		System.out.println("Aliens win");
		System.exit(0);
	}
	
	private void win() {
		System.out.println("Player wins");
		System.exit(0);
	}*/

	

	public void run() {
		BoardPrinter draw;
		System.out.println(game.infoToString());
		draw = new BoardPrinter(game, 8, 9);
		System.out.println(draw.toString());
		System.out.println("Command > ");
		while (!end) {
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			Command command = CommandGenerator.parseCommand(words);

			if (command != null) {
				if (command.execute(game)) {
					game.update();
					System.out.println(game.infoToString());
					draw = new BoardPrinter(game, 8, 9);
					System.out.println(draw.toString());
					System.out.println("Command > ");
				}
			}else {
				System.out.format("COMANDO ERRRONEO\n");
				System.out.println("Command > ");
			}
			/*if(!game.pasarTurno()) {
				end = true;
			}*/
		}
		/*if(game.win()) {
			
			win();
		}else {
			gameOver();
		}*/
	}
}
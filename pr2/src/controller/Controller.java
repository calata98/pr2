package controller;

import java.util.Scanner;

import command.BuyMissileCommand;
import command.Command;
import command.CommandGenerator;
import command.HelpCommand;
import command.ListCommand;
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
					if(!(command instanceof HelpCommand) && !(command instanceof ListCommand) && !(command instanceof BuyMissileCommand)) {
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
			}else {
				System.out.format("COMANDO ERRRONEO\n");
				System.out.println("Command > ");
			}
			if(game.isFinished()) {
				end = true;
			}
		}
		System.out.println(game.getWinnerMessage());
	}
}
package controller;

import java.util.Scanner;

import command.BuyMissileCommand;
import command.Command;
import command.CommandGenerator;
import command.HelpCommand;
import command.ListCommand;
import command.StringifyCommand;
import game.Game;
import interfaces.GamePrinter;
import Printers.BoardPrinter;
import Printers.PrinterTypes;
import Printers.Stringifier;

public class Controller {

	private Game game;
	private boolean end = false;
	Scanner in;
	private PrinterTypes printer;

	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
		printer = game.getPrinter();
	}

	public void run() {
		System.out.println(game.infoToString());
		System.out.println(printer.getObject().toString(game));
		System.out.println("Command > ");
		while (!end) {
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null) {
				if (command.execute(game)) {
					printer =  game.getPrinter();
					game.update();
					if(game.getUpdate()) {
						System.out.println(printer.getObject().toString(game));
					}
					game.setPrinter(PrinterTypes.BOARDPRINTER);
					game.setUpdate(true);
				}else {
					System.out.format("COMANDO ERRRONEO\n");
				}
			}else {
				System.out.format("COMANDO ERRRONEO\n");
			}
			System.out.println("Command > ");
			if(game.isFinished()) {
				end = true;
			}
		}
		System.out.println(game.getWinnerMessage());
	}
}
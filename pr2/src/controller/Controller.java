package controller;

import java.util.Scanner;

import Printers.PrinterTypes;
import command.Command;
import command.CommandGenerator;
import command.ExitCommand;
import command.HelpCommand;
import command.ListCommand;
import command.ListPrintersCommand;
import command.SaveCommand;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import game.Game;


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
			try {
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null) {
				if (command.execute(game)) {
					printer =  game.getPrinter();
					game.update();
					if(!(command instanceof HelpCommand) && !(command instanceof ListCommand) && !(command instanceof ListPrintersCommand) 
							&& !(command instanceof SaveCommand) && !(command instanceof ExitCommand)) {
						System.out.println(printer.getObject().toString(game));
					}
					game.setPrinter(PrinterTypes.BOARDPRINTER);
					game.setUpdate(true);
				}
			}
			}catch(CommandParseException e) {
					System.err.println(e.getMessage());
					System.out.println();
					
				}catch(CommandExecuteException e) {
					System.err.println(e.getMessage());
					System.out.println();
					
				}catch(NumberFormatException e) {
					System.err.println("Invalid argument for move command, number expected");
					System.out.println();
				}
			System.out.println("Command > ");
			if(game.isFinished()) {
				end = true;
			}
		}
		System.out.println(game.getWinnerMessage());
	}
}
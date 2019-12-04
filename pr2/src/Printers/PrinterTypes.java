package Printers;

import game.Game;
import interfaces.GamePrinter;

public enum PrinterTypes {
	
	BOARDPRINTER("boardprinter",
			"prints the game formatted as a board of dimension: ",
			new BoardPrinter(Game.DIM_X + 1,Game.DIM_Y + 1)),
	STRINGIFIER("stringifier",
			"prints the game as plain text",
			new Stringifier());
	
	private String printerName;
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
	
	public static String printerHelp() {
		String helpString = "";
		for (PrinterTypes printer : PrinterTypes.values())
			helpString += String.format("%s : %s%s%n", printer.printerName, printer.helpText,
				(printer == BOARDPRINTER ? (Game.DIM_X + 1) + " x " + (Game.DIM_Y + 1) : "") );
		return helpString;
	}
	
	public GamePrinter getObject() {
		return printerObject;
	}

}

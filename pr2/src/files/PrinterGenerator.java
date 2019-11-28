package files;

import interfaces.GamePrinter;
import game.BoardPrinter;

public class PrinterGenerator {

	private static GamePrinter[] availablePrinters = {
			new BoardPrinter(Game.DIM_X, Game.DIM_Y),
			new Serializer(),
			
		};

		public static GamePrinter parse(String name) {		
			GamePrinter printer = null;
			for (GamePrinter p: availablePrinters) {
				printer = p.parse(name);
				if (printer != null) break;
			}
			return printer;
		}
			
		public static String printerHelp() {
			StringBuilder printers = new StringBuilder();	
			for (GamePrinter p: availablePrinters)
				printers.append(p.helpText());
			return printers.toString();
		}
	
}

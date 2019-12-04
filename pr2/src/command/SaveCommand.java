package command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Printers.PrinterTypes;
import game.Game;

public class SaveCommand extends Command {
	private BufferedWriter bWriter;
	private FileWriter writer;
	private String name;
	

	public SaveCommand() {
		super("Save", "Save","Save","save the game in a archive with the name given.");
	}
	public SaveCommand(String name) {
		super("Save", "Save","Save","save the game in a archive with the name given.");
		this.name = name;
	}

	public boolean execute(Game game) {
		game.setPrinter(PrinterTypes.STRINGIFIER);
		try {
			writer = new FileWriter(this.name +".dat");
			bWriter = new BufferedWriter(writer);
			bWriter.write(game.getPrinter().getObject().toString(game));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            try {
                if (bWriter != null)
                	bWriter.close();

                if (writer != null)
                	writer.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
		
		game.setUpdate(false);
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		if(commandWords.length == 2 && commandWords[0].toLowerCase().equals("save")) {
			command = new SaveCommand(commandWords[1]);
		}
		return command;
	}
}

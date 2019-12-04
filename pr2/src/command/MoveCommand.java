package command;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import game.Game;

public class MoveCommand extends Command {
private int n;
private String m;
	public MoveCommand() {
		super("Move", "m","Move","move <left|right><1|2>: Moves UCM-Ship to the indicated direction.");
	}
	public MoveCommand(String m,int num) {
		super("Move", "m","move a ucmship","move <left|right><1|2>: Moves UCM-Ship to the indicated direction.");
		n=num;
		this.m=m;
	}
	public boolean execute(Game game) throws CommandExecuteException {
		
		if(!game.move(m,n)) {
			throw new CommandExecuteException("fuera tablero");
		}
		return true;
	}
	public Command parse(String[] commandWords) throws CommandParseException{
		Command command=null;
	if(!commandWords[0].equals("move") && !commandWords[0].equals("m")) {
		return null;
	}
	else if(commandWords.length!=3) {
		throw new CommandParseException("Incorrect number of arguments for move command: move <left|right><1|2>");
	}
	else if ((commandWords[0].equals("move") || commandWords[0].equals("m")) && commandWords.length == 3 && (commandWords[1].equals("left") || commandWords[1].equals("right"))
				&& (commandWords[2].equals("1") || commandWords[2].equals("2")))
		 		{
				
					command = new MoveCommand(commandWords[1],Integer.parseInt(commandWords[2]));
					return command;
				}
		 else {
		 
		 throw new CommandParseException("Failed to move UCM "+ commandWords[1] +" "+ commandWords[2]);
	}
	}
}
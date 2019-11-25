package command;

import game.Game;

public class MoveCommand extends Command {
private String move;
private int n;
	public MoveCommand() {
		super("Move", "m","Move","move <left|right><1|2>: Moves UCM-Ship to the indicated direction.");
	}
	public MoveCommand(String m,int num) {
		super("Move", "m","move a ucmship","move <left|right><1|2>: Moves UCM-Ship to the indicated direction.");
		move=m;
		n=num;
	}
	public boolean execute(Game game) {
		game.movePlayer(move,n);
		return true;
	}
	public Command parse(String[] commandWords) {
		Command command=null;
		if ((commandWords[0].equals("move") || commandWords[0].equals("m")) && commandWords.length == 3 && (commandWords[1].equals("left") || commandWords[1].equals("right"))
				&& (commandWords[2].equals("1") || commandWords[2].equals("2")))
		 		{
					command = new MoveCommand(commandWords[1],Integer.parseInt(commandWords[2]));
				}
		return command;
	}
}
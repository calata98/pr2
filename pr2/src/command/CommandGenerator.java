package command;

import exceptions.CommandParseException;

public class CommandGenerator {

	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand(),
			new BuyMissileCommand(),
			new StringifyCommand(),
			new ListPrintersCommand(),
			new SaveCommand()
			};
	public static Command parseCommand(String[ ] commandWords)throws CommandParseException {
		Command command = null;
		int i=0;
		while(i<availableCommands.length) {
			if(command==null)
			{
			command=availableCommands[i].parse(commandWords);
			i++;
			}
			else
			{
				return command;
			
			}
		}
		throw new CommandParseException("Unknown command");
		
	}
	public static void commandHelp() {
		for(int i=0;i<availableCommands.length;i++) {
			System.out.println(availableCommands[i].helpText());
		}
	}
}
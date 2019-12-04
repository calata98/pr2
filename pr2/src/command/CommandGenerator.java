package command;

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
			new StringifyCommand()
			};
	public static Command parseCommand(String[ ] commandWords) {
		Command command=null;
		int i=0;
		while(command==null&&i<availableCommands.length) {
			command=availableCommands[i].parse(commandWords);
			i++;
		}
		return command;
	}
	public static void commandHelp() {
		for(int i=0;i<availableCommands.length;i++) {
			System.out.println(availableCommands[i].helpText());
		}
	}
}
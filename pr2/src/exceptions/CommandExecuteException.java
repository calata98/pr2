package exceptions;

public class CommandExecuteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243402929611985729L;
	String error;
	public CommandExecuteException(String error) {
		this.error = error;
	}
	public String getMessage() {
		return error;
	}

}

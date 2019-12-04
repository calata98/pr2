package exceptions;

public class CommandParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2721846180622131152L;
	String error;
	public CommandParseException(String error) {
		this.error = error;
	}
	public String getMessage() {
		return error;
	}
}

package exceptions;

public class FileContentsException extends Exception {
	
	String error;
	public FileContentsException(String error) {
		this.error = error;
	}
	public String getMessage() {
		return error;
	}
}

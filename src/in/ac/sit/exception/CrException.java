package in.ac.sit.exception;

public class CrException extends Exception{
	
	String details;

	public CrException(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

}

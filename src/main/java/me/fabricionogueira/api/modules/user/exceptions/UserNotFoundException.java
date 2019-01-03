package me.fabricionogueira.api.modules.user.exceptions;

public class UserNotFoundException extends UserException {

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException() {
		super("User Not found");
	}
}

package me.fabricionogueira.api.modules.user.exceptions;

public class UserNotFound extends UserException {

	public UserNotFound(String message) {
		super(message);
	}

	public UserNotFound() {
		super("User Not found");
	}
}

package me.fabricionogueira.api.modules.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends UserException {

	public UserNotFound(String message) {
		super(message);
	}

	public UserNotFound() {
		super("User Not found");
	}
}

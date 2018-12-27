package me.fabricionogueira.api.modules.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserUnauthorizedException extends UserException {

	public UserUnauthorizedException(String message) {
		super(message);
	}

	public UserUnauthorizedException() {
		super("Not authorized");
	}
}

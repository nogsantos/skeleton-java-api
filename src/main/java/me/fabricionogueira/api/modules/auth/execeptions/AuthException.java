package me.fabricionogueira.api.modules.auth.execeptions;

public class AuthException extends RuntimeException {
	AuthException(String message) {
		super(message);
	}
}


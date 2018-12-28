package me.fabricionogueira.api.modules.user.exceptions;

import me.fabricionogueira.api.config.exception.ExceptionDefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@RestController
public class UserExceptionMapper extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionDefaultResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionDefaultResponse exceptionDefaultResponse = new ExceptionDefaultResponse(
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<>(exceptionDefaultResponse, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionDefaultResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
		ExceptionDefaultResponse exceptionDefaultResponse = new ExceptionDefaultResponse(
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<>(exceptionDefaultResponse, NOT_FOUND);
	}

	@ExceptionHandler(UserUnauthorizedException.class)
	public final ResponseEntity<ExceptionDefaultResponse> handleUserUnauthorizedException(Exception ex, WebRequest request) {
		ExceptionDefaultResponse exceptionDefaultResponse = new ExceptionDefaultResponse(
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<>(exceptionDefaultResponse, UNAUTHORIZED);
	}
}

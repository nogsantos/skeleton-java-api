package me.fabricionogueira.api.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static org.springframework.http.HttpStatus.*;

/**
 * Request default response
 */
@Component
public class DefaultApiResponse {


	private HttpHeaders responseHeaders;

	/**
	 * Header
	 */
	private DefaultApiResponse() {
		this.responseHeaders = new HttpHeaders();
		this.responseHeaders.set("API", "Fabricio Nogueira");
	}

	/**
	 * Generic response for collections.
	 *
	 * @param <E> Element
	 */
	public <E> ResponseEntity<Collection<E>> ok(Collection<E> entyties) {
		return new ResponseEntity<>(entyties, this.responseHeaders, OK);
	}

	/**
	 * Generic response for Object.
	 *
	 * @param <T> Type
	 * @param <T> Body values of type
	 */
	public <T> ResponseEntity<T> ok(T body) {
		return new ResponseEntity<>((T) body, this.responseHeaders, OK);
	}

	/**
	 * Not found
	 */
	public <T> ResponseEntity<T> notFound() {
		return new ResponseEntity<>(null, this.responseHeaders, NOT_FOUND);
	}

	/**
	 * Unauthorized
	 */
	public <T> ResponseEntity<T> unauthorized() {
		return new ResponseEntity<>(null, this.responseHeaders, UNAUTHORIZED);
	}

	/**
	 * When request fail
	 *
	 * @param <T> Type
	 */
	public <T> ResponseEntity<T> requestFail() {
		return new ResponseEntity<>(null, this.responseHeaders, SERVICE_UNAVAILABLE);
	}
}

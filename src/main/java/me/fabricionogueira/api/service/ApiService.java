package me.fabricionogueira.api.service;

import java.util.Hashtable;

/**
 * Layer for business
 */
public class ApiService {

	/**
	 * Response
	 *
	 * @param <T>
	 *
	 * @param String key
	 * @param T body
	 * @return Hashtable<String, T>
	 */
	public static <T> Hashtable<String, T> response(String key, T body) {
		Hashtable<String, T> output = new Hashtable<String, T>();
		output.put(key, body);
		return output;
	}
}

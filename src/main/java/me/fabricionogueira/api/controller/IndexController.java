package me.fabricionogueira.api.controller;

import java.util.Hashtable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.fabricionogueira.api.resource.ApiResponse;
import me.fabricionogueira.api.service.ApiService;
/**
 * Index controller
 *
 */
@RestController
@RequestMapping("/")
public class IndexController {

	/**
	 * Get
	 *
	 * @return Json
	 */
	@GetMapping("/")
	public ResponseEntity<Hashtable<String, String>> getAll() {
		return ApiResponse.getInstance().ok(ApiService.response("Success", "Hellow there!"));
	}

}

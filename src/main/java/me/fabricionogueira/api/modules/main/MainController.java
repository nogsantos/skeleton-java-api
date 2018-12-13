package me.fabricionogueira.api.modules.main;

import io.swagger.annotations.*;
import me.fabricionogueira.api.resource.DefaultApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(description = "Main application endpoint")
public class MainController {

	private final DefaultApiResponse response;

	@Autowired
	public MainController(DefaultApiResponse response) {
		this.response = response;
	}

	@GetMapping("/")
	@ApiOperation(
		value = "Main resource",
		notes = "Update with necessaries"
	)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Request Success")
	})
	public ResponseEntity<String> main() {
		return response.ok("Hellow there!");
	}

	@GetMapping("/param")
	@ApiOperation(
		value = "Resource with param",
		notes = "Enabled and documenting params"
	)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Request Success")
	})
	public ResponseEntity<String> hello(
		@RequestParam(required = true)
		@ApiParam(value = "Some string value")
			String param) {

		return response.ok("Hello " + param);
	}
}

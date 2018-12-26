package me.fabricionogueira.api.modules.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.fabricionogueira.api.modules.user.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(description = "Users controller")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@ApiOperation("Recovery user password by email address")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Email successfully sent"),
		@ApiResponse(code = 400, message = "Processing request error"),
		@ApiResponse(code = 404, message = "Token not founded")
	})
	@GetMapping("/password/recovery")
	public String passwordRecovery(@RequestParam(required = true) String email) throws UserException {
		return service.recoveryPassword(email);
	}

}

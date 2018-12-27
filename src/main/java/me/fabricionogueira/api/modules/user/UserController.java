package me.fabricionogueira.api.modules.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.fabricionogueira.api.modules.user.dto.UserDefault;
import me.fabricionogueira.api.modules.user.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(description = "Users controller")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@ApiOperation("Get user details")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successfully sent"),
		@ApiResponse(code = 400, message = "Processing request error"),
		@ApiResponse(code = 404, message = "Not found")
	})
	@GetMapping("/")
	@PreAuthorize("hasAuthority('USER') OR hasAuthority('ADMIN') OR hasAuthority('SUPER_ADMIN')")
	public UserDefault getDetails(@RequestHeader String token) throws UserException {
		return service.getDetailsByToken(token);
	}

	@ApiOperation("Recovery user password by email address")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successfully sent"),
		@ApiResponse(code = 400, message = "Processing request error"),
		@ApiResponse(code = 404, message = "Not found")
	})
	@GetMapping("/password/recovery")
	@PreAuthorize("hasAuthority('USER') OR hasAuthority('ADMIN') OR hasAuthority('SUPER_ADMIN')")
	public String passwordRecovery(@RequestParam(required = true) String email) throws UserException {
		return service.recoveryPassword(email);
	}

}

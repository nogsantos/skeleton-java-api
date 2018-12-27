package me.fabricionogueira.api.modules.auth;

import me.fabricionogueira.api.modules.user.User;
import me.fabricionogueira.api.modules.user.UserMapper;
import me.fabricionogueira.api.modules.user.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("auth")
@Transactional
public class AuthController {

	private ConsumerTokenServices tokenServices;
	private UserMapper userMapper;

	@Autowired
	public AuthController(ConsumerTokenServices tokenServices, UserMapper userMapper) {
		this.tokenServices = tokenServices;
		this.userMapper = userMapper;
	}

	@GetMapping("whoAmI")
	public Object whoAmI() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getPrincipal();
	}

	@GetMapping("logout")
	public ResponseEntity<?> logout() {
		Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();

		if (details instanceof OAuth2AuthenticationDetails) {
			return ResponseEntity.status(OK).body(
				tokenServices.revokeToken(((OAuth2AuthenticationDetails) details).getTokenValue())
			);
		}

		return ResponseEntity.status(BAD_REQUEST).body(new UserNotFound());
	}
}

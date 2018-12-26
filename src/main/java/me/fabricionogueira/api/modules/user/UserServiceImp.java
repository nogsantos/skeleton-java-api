package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.exceptions.UserException;
import me.fabricionogueira.api.modules.user.exceptions.UserUnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Override
	public String recoveryPassword(String email) throws UserException {

		isAuthenticated();

		return "some";

	}

	private void isAuthenticated() throws UserUnauthorizedException {
		Object authUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(authUser instanceof User)) {
			throw new UserUnauthorizedException();
		}
	}
}

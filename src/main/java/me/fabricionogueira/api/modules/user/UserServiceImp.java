package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.exceptions.UserException;
import me.fabricionogueira.api.modules.user.exceptions.UserUnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImp implements UserService, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}

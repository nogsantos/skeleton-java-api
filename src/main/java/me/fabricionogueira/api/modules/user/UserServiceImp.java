package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.exceptions.UserException;
import me.fabricionogueira.api.modules.user.exceptions.UserUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service(value = "userService")
public class UserServiceImp implements UserService, UserDetailsService {


	private UserRepository repository;

	@Autowired
	public UserServiceImp(UserRepository repository) {
		this.repository = repository;
	}

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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findOneByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Collections.singletonList(
			new SimpleGrantedAuthority("ROLE_ADMIN")
		);
	}
}

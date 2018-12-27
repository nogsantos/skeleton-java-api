package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.role.Role;
import me.fabricionogueira.api.modules.user.dto.UserDefault;
import me.fabricionogueira.api.modules.user.exceptions.UserException;
import me.fabricionogueira.api.modules.user.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	private UserRepository repository;
	private UserMapper mapper;

	@Autowired
	public UserServiceImp(UserRepository repository, UserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public String recoveryPassword(String email) throws UserException {
		return "some";
	}

	@Override
	public UserDetails findOneByEmail(String email) throws UsernameNotFoundException {
		User user = repository.findOneByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with email %s doesn't exist", email));
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return toUserDetails(user, authorities);
	}

	@Override
	public UserDefault getDetailsByToken(String token) throws UserNotFound {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final String name = auth.getName();
		final String[] split = name.split("#");
		final User user = repository.getOne(Long.parseLong(split[0]));
		return mapper.toDefaultValues(user);
	}

	private UserDetails toUserDetails(User user, List<GrantedAuthority> authorities) {

		return org.springframework.security.core.userdetails.User
			.withUsername(user.getId()+"#"+user.getName())
			.password(user.getPassword())
			.authorities(authorities)
			.build();
	}
}

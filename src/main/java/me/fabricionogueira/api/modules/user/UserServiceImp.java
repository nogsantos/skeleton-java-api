package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.role.Role;
import me.fabricionogueira.api.modules.user.dto.UserDefault;
import me.fabricionogueira.api.modules.user.exceptions.UserException;
import me.fabricionogueira.api.modules.user.exceptions.UserNotFoundException;
import me.fabricionogueira.api.resource.DefaultApiResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	final private UserRepository repository;
	final private UserMapper mapper;
	final private DefaultApiResponse response;

	@Autowired
	public UserServiceImp(UserRepository repository, UserMapper mapper, DefaultApiResponse response) {
		this.repository = repository;
		this.mapper = mapper;
		this.response = response;
	}

	@Override
	public String recoveryPassword(String email) throws UserException {
		return "some";
	}

	@Override
	public UserDetails findOneByEmail(String email) throws UserException {
		User user = repository.findOneByEmail(email);

		if (user == null) {
			throw new UserNotFoundException(String.format("User with email %s doesn\'t exist", email));
		}

		Set<GrantedAuthority> authorities = new HashSet<>();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return toUserDetails(user, authorities);
	}

	@Override
	public ResponseEntity<UserDefault> getDetailsByToken() throws UserNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jo = new JSONObject(auth.getName());
		final User user = repository.getOne(Long.parseLong(jo.get("id").toString()));
		return response.ok(mapper.toDefaultValues(user));
	}

	/**
	 * For authentication purposes
	 *
	 * @param user        User
	 * @param authorities Set<GrantedAuthority
	 * @return UserDetails
	 */
	private UserDetails toUserDetails(User user, Set<GrantedAuthority> authorities) {
		JSONObject userDetails = new JSONObject();
		userDetails.put("id", user.getId());
		userDetails.put("name", user.getName());
		userDetails.put("email", user.getEmail());
		return org.springframework.security.core.userdetails.User
			.withUsername(userDetails.toString())
			.password(user.getPassword())
			.authorities(authorities)
			.build();
	}
}

package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.role.Role;
import me.fabricionogueira.api.modules.tests.utils.Generate;

import java.util.ArrayList;
import java.util.List;

public class UserDataBuilder {

	private final User user;
	private List<Role> roles = new ArrayList<>();

	public UserDataBuilder() {
		User user = new User();
		user.setId(Generate.value());
		user.setName(Generate.value(20));
		user.setEmail(Generate.email(20));
		user.setActive(Generate.active());
		user.setPassword(Generate.value(40));
		this.user = user;
	}

	public UserDataBuilder(boolean isActive) {
		User user = new User();
		user.setId(Generate.value());
		user.setName(Generate.value(20));
		user.setEmail(Generate.email(20));
		user.setActive(isActive);
		user.setPassword(Generate.value(40));
		this.user = user;
	}

	public UserDataBuilder withRole(Role role) {
		this.roles.add(role);
		return this;
	}

	public User build() {
		this.user.setRoles(this.roles);
		return this.user;
	}

}

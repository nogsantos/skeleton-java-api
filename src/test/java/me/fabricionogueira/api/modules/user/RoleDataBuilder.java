package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.role.Role;
import me.fabricionogueira.api.modules.tests.utils.Generate;

public class RoleDataBuilder {

	private final Role role;

	public RoleDataBuilder() {
		Role role = new Role();
		role.setId(Generate.value());
		role.setName(Generate.value(20));
		role.setDescription(Generate.value(40));
		this.role = role;
	}

	public Role build() {
		return this.role;
	}

}

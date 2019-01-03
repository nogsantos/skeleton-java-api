package me.fabricionogueira.api.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fabricionogueira.api.modules.role.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDefault {
	private Long id;
	private String name;
	private String email;
	private List<Role> roles;
	private boolean active;
}

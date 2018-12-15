package me.fabricionogueira.api.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDefault {

	private Long id;
	private String name;
	private String email;
	private boolean active;

}

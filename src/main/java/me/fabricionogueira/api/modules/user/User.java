package me.fabricionogueira.api.modules.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fabricionogueira.api.modules.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 99)
	private String name;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	@Size(min = 8)
	private String password;

	@Builder.Default
	private boolean active = false;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_role",
		joinColumns = @JoinColumn(
			name = "user_id",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name = "role_id",
			referencedColumnName = "id")
	)
	private List<Role> roles;

}

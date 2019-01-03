package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.dto.UserDefault;
import org.mapstruct.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDefault toDefaultValues(User user);
}

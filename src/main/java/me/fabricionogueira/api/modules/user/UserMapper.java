package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.dto.UserDefault;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDefault toDefaultValues(User user);

}

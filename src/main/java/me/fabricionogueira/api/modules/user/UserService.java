package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.dto.UserDefault;
import me.fabricionogueira.api.modules.user.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

	String recoveryPassword(String email) throws UserException;

	UserDetails findOneByEmail(String email) throws UsernameNotFoundException;

	ResponseEntity<UserDefault> getDetailsByToken() throws UserException;
}

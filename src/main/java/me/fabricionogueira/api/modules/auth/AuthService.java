package me.fabricionogueira.api.modules.auth;

import me.fabricionogueira.api.modules.auth.execeptions.AuthException;
import org.springframework.http.ResponseEntity;

public interface AuthService {

	ResponseEntity<String> logout() throws AuthException;

}

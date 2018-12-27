package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.exceptions.UserException;

public interface UserService {

	String recoveryPassword(String email) throws UserException;
}

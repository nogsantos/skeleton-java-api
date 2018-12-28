package me.fabricionogueira.api.modules.user;

import me.fabricionogueira.api.modules.user.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository repository;

	@InjectMocks
	private UserServiceImp service;

	@Test
	public void itReturnsAnStringWhenTryingToRecoverThePassword() {
		String asd = service.recoveryPassword("asd");
		assertThat(asd, is(equalTo("some")));
	}

	@Test(expected = UserNotFoundException.class)
	public void itReturnsAnExceptionWhenTryingToFindAnUserByEmailAndTheUserIsNull() {

		when(repository.findOneByEmail(any())).thenReturn(null);

		service.findOneByEmail(any());
	}

}

package com.churros.domain;

import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.domain.user.User;

public class UserTest {

    @Test
    public void givenAValidParams_whenCallNewUser_thenInstantiateAnUser() {
		final String name = "Test Name User";
		final String email = "test@example";
		final String password = "fakepassword";
		final Instant birthDate = Instant.now();
		final Boolean isActive = true;

		final User user = User.newUser(name, email, password, birthDate, isActive);

		Assertions.assertNotNull(user);
		Assertions.assertEquals(user.getName(), name);
		Assertions.assertEquals(user.getEmail(), email);
		Assertions.assertEquals(user.getPassword(), password);
		Assertions.assertEquals(user.getBirthDate(), birthDate);
		Assertions.assertEquals(user.isActive(), isActive);
		Assertions.assertNotNull(user.getId());
		Assertions.assertNotNull(user.getCreatedAt());
		Assertions.assertNotNull(user.getUpdatedAt());
		Assertions.assertNull(user.getDeletedAt());

    }
}

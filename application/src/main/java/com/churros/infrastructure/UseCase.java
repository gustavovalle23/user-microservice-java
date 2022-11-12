package com.churros.infrastructure;

import java.time.Instant;

import com.churros.domain.user.User;

public class UseCase {
	public User perform() {
		return User.newUser("UserTest", "email@gmail.com", "password", Instant.now(), true);
	}
}

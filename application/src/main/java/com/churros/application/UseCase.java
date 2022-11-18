package com.churros.application;

import java.time.LocalDate;

import com.churros.domain.user.User;

public class UseCase {
	public User perform() {
		return User.newUser("UserTest", "email@gmail.com", "password", LocalDate.now(), true);
	}
}

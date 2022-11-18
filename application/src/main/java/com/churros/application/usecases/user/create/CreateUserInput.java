package com.churros.application.usecases.user.create;

import java.time.LocalDate;

public record CreateUserInput(
		String name,
		String email,
		String password,
		LocalDate birthDate) {

	public static CreateUserInput with(
			final String name,
			final String email,
			final String password,
			final LocalDate birthDate) {
		return new CreateUserInput(name, email, password, birthDate);
	}
};

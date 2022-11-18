package com.churros.application.usecases.user.create;

public record CreateUserInput(
		String name,
		String email,
		String password,
		String birthDate) {

	public static CreateUserInput with(
			final String name,
			final String email,
			final String password,
			final String birthDate) {
		return new CreateUserInput(name, email, password, birthDate);
	}
};

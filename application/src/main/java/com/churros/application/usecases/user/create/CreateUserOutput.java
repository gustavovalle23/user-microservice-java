package com.churros.application.usecases.user.create;

import java.time.LocalDate;

public record CreateUserOutput(
		String name,
		String email,
		String password,
		LocalDate birthDate,
		Boolean active,
		String createdAt,
		String updatedAt,
		String deletedAt) {

	public static CreateUserOutput with(
			final String name,
			final String email,
			final String password,
			final LocalDate birthDate,
			final Boolean active,
			final String createdAt,
			final String updatedAt,
			final String deletedAt) {
		return new CreateUserOutput(name, email, password, birthDate, active, createdAt, updatedAt, deletedAt);
	}
};

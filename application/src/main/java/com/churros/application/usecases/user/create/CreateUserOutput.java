package com.churros.application.usecases.user.create;

import java.time.Instant;
import java.time.LocalDate;

public record CreateUserOutput(
		String id,
		String name,
		String email,
		String password,
		LocalDate birthDate,
		Boolean active,
		Instant createdAt,
		Instant updatedAt,
		Instant deletedAt) {

	public static CreateUserOutput with(
			final String id,
			final String name,
			final String email,
			final String password,
			final LocalDate birthDate,
			final Boolean active,
			final Instant createdAt,
			final Instant updatedAt,
			final Instant deletedAt) {

		return new CreateUserOutput(
				id,
				name,
				email,
				password,
				birthDate,
				active,
				createdAt,
				updatedAt,
				deletedAt);
	}
};

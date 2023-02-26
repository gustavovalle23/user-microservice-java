package com.churros.application.usecases.user.create;

import java.time.Instant;
import java.time.LocalDate;

import com.churros.domain.user.User;

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

	public static CreateUserOutput from(
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

	public static CreateUserOutput from(User user) {

		return new CreateUserOutput(
				user.getId().getValue(),
				user.getName(),
				user.getEmail(),
				user.getEmail(),
				user.getBirthDate(),
				user.isActive(),
				user.getCreatedAt(),
				user.getUpdatedAt(),
				user.getDeletedAt());
	}
}

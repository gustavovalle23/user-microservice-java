package com.churros.application.usecases.user.create;

import java.time.Instant;

import com.churros.application.UseCase;

public class CreateUserUseCase extends UseCase<CreateUserInput, CreateUserOutput> {
	public CreateUserOutput execute(CreateUserInput input) {
		return new CreateUserOutput(
				"123",
				input.name(),
				input.email(),
				input.password(),
				input.birthDate(),
				true,
				Instant.now(),
				Instant.now(),
				null);
	}
}

package com.churros.application.usecases.user.create;

import java.time.Instant;

import com.churros.application.UseCase;
import com.churros.domain.user.UserGateway;

public class CreateUserUseCase extends UseCase<CreateUserInput, CreateUserOutput> {
	final UserGateway userGateway;

	public CreateUserUseCase(final UserGateway userGateway) {
		this.userGateway = userGateway;
	}

	@Override
	public CreateUserOutput execute(CreateUserInput input) {
		return CreateUserOutput.from(
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

package com.churros.application.usecases.user.create;

import java.time.Instant;
import java.time.LocalDate;

import com.churros.application.UseCase;
import com.churros.domain.user.User;
import com.churros.domain.user.UserGateway;

public class CreateUserUseCase implements UseCase<CreateUserInput, CreateUserOutput> {
	final UserGateway userGateway;

	public CreateUserUseCase(final UserGateway userGateway) {
		this.userGateway = userGateway;
	}

	@Override
	public CreateUserOutput execute(CreateUserInput input) {
		final String name = input.name();
		final String email = input.email();
		final String password = input.password();
		final LocalDate birthDate = input.birthDate();
		final boolean isActive = true;

		final User anUser = User.newUser(name, email, password, birthDate, isActive);

		return CreateUserOutput.from(this.userGateway.create(anUser));
	}
}

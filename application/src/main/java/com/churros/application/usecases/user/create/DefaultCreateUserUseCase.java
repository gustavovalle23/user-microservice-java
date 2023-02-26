package com.churros.application.usecases.user.create;

import java.time.LocalDate;

import com.churros.application.UseCase;
import com.churros.domain.exceptions.UserAlreadyExistsException;
import com.churros.domain.user.User;
import com.churros.domain.user.UserRepository;

public class DefaultCreateUserUseCase implements UseCase<CreateUserInput, CreateUserOutput> {
	private final UserRepository userRepository;

	public DefaultCreateUserUseCase(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public CreateUserOutput execute(final CreateUserInput input) {
		if (this.userRepository.findByEmail(input.email()).isPresent()) {
			throw new UserAlreadyExistsException(input.email());
		}

		final User anUser = User.newUser(input.name(), input.email(), input.password(), input.birthDate(), true);

		User createdUser = this.userRepository.create(anUser);
		return CreateUserOutput.from(createdUser);
	}
}

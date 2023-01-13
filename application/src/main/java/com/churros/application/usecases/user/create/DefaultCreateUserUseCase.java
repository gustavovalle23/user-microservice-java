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
	public CreateUserOutput execute(final CreateUserInput user) {
		if (this.userRepository.findByEmail(user.email()).isPresent()) {
			throw new UserAlreadyExistsException(user.email());
		}

		final String name = user.name();
		final String email = user.email();
		final String password = user.password();
		final LocalDate birthDate = user.birthDate();
		final boolean isActive = true;

		final User anUser = User.newUser(name, email, password, birthDate, isActive);

		User createdUser = this.userRepository.create(anUser);
		return CreateUserOutput.from(createdUser);
	}
}

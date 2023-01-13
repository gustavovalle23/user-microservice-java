package com.churros.application.usecases.create;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import com.churros.application.UseCaseTest;
import com.churros.domain.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.application.usecases.user.create.CreateUserInput;
import com.churros.application.usecases.user.create.CreateUserOutput;
import com.churros.application.usecases.user.create.DefaultCreateUserUseCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

class TestCreateUserUseCase extends UseCaseTest {

	@InjectMocks
	private DefaultCreateUserUseCase useCase;

	@Mock
	private UserRepository userRepository;

	@Override
	protected List<Object> getMocks() {
		return List.of(userRepository);
	}

	@Test
	void givenAValidInput_whenCallsCreateUser_shouldReturnUser() {
		DefaultCreateUserUseCase usecase = new DefaultCreateUserUseCase(userRepository);
		CreateUserInput input = new CreateUserInput("Tester", "tester@gmail.com", "123", LocalDate.now());

		when(userRepository.create(any()))
				.thenAnswer(returnsFirstArg());

		CreateUserOutput output = usecase.execute(input);

		Assertions.assertNotNull(output);
		Assertions.assertEquals(output.name(), input.name());
		Assertions.assertEquals(output.email(), input.email());
		Assertions.assertEquals(output.password(), output.password());
		Assertions.assertEquals(output.birthDate(), input.birthDate());
		Assertions.assertNotNull(output.createdAt());
		Assertions.assertNotNull(output.updatedAt());
		Assertions.assertNull(output.deletedAt());
	}

}

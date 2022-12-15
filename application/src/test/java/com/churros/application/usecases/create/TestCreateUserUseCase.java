package com.churros.application.usecases.create;

import java.time.LocalDate;
import java.util.List;

import com.churros.application.UseCaseTest;
import com.churros.domain.user.UserGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.application.usecases.user.create.CreateUserInput;
import com.churros.application.usecases.user.create.CreateUserOutput;
import com.churros.application.usecases.user.create.CreateUserUseCase;
import org.mockito.Mock;

class TestCreateUserUseCase extends UseCaseTest {

    @Mock
    private UserGateway userGateway;

    @Override
    protected List<Object> getMocks() {
        return List.of(userGateway);
    }

    @Test
    void testCreateUseCase() {
		CreateUserUseCase usecase = new CreateUserUseCase(userGateway);
		CreateUserInput input = new CreateUserInput("Tester", "tester@gmail.com", "123", LocalDate.now());
		CreateUserOutput output = usecase.execute(input);

		Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());
        Assertions.assertEquals(output.name(), input.name());
        Assertions.assertEquals(output.email(), input.email());
        Assertions.assertEquals(output.password(), output.password());
        Assertions.assertEquals(output.birthDate(), input.birthDate());
		Assertions.assertNotNull(output.createdAt());
		Assertions.assertNotNull(output.updatedAt());
		Assertions.assertNull(output.deletedAt());
    }


}

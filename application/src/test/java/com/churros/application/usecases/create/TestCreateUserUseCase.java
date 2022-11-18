package com.churros.application.usecases.create;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.application.usecases.user.create.CreateUserInput;
import com.churros.application.usecases.user.create.CreateUserOutput;
import com.churros.application.usecases.user.create.CreateUserUseCase;

public class TestCreateUserUseCase {

    @Test
    public void testCreateUseCase() {
		CreateUserUseCase usecase = new CreateUserUseCase();
		CreateUserInput input = new CreateUserInput("Tester", "tester@gmail.com", "123", LocalDate.now());
		CreateUserOutput output = usecase.execute(input);
        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());
        Assertions.assertEquals(output.name(), input.name());
        Assertions.assertEquals(output.email(), input.email());
        Assertions.assertEquals(output.password(), output.password()); // TODO: change to notequals - hash password algorithm
        Assertions.assertEquals(output.birthDate(), input.birthDate());
		Assertions.assertNotNull(output.createdAt());
		Assertions.assertNotNull(output.updatedAt());
		Assertions.assertNull(output.deletedAt());
    }
}

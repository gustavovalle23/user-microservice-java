package com.churros.application.usecases.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.application.usecases.user.find.FindUserInput;
import com.churros.application.usecases.user.find.FindUserOutput;
import com.churros.application.usecases.user.find.FindUserUseCase;

public class TestFindUserUseCase {

    @Test
    public void testFindUserUseCase() {
		FindUserUseCase usecase = new FindUserUseCase();
		FindUserInput input = new FindUserInput("123");
		FindUserOutput output = usecase.execute(input);
		Assertions.assertEquals(input, output);
    }
}

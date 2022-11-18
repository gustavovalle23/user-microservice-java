package com.churros.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.application.UseCase;

public class TestUseCase {

    @Test
    public void testCreateUseCase() {
        Assertions.assertNotNull(new UseCase());
        Assertions.assertNotNull(new UseCase().perform());
    }
}

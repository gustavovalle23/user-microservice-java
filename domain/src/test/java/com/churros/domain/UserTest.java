package com.churros.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testNewUser() {
        Assertions.assertNotNull(new User());
    }
}

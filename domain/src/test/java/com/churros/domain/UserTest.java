package com.churros.domain;

import java.time.LocalDate;

import com.churros.domain.exceptions.NotificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.churros.domain.exceptions.DomainException;
import com.churros.domain.user.User;
import com.churros.domain.validation.ThrowsValidationHandler;

class UserTest {

    @Test
    void givenAValidParams_whenCallNewUser_thenInstantiateAnUser() {
        final String name = "Test Name User";
        final String email = "test@example.com";
        final String password = "fakepassword";
        final LocalDate birthDate = LocalDate.now();
        final Boolean isActive = true;

        final User user = User.newUser(name, email, password, birthDate, isActive);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(), name);
        Assertions.assertEquals(user.getEmail(), email);
        Assertions.assertEquals(user.getPassword(), password);
        Assertions.assertEquals(user.getBirthDate(), birthDate);
        Assertions.assertEquals(user.isActive(), isActive);
        Assertions.assertNotNull(user.getId().getValue());
        Assertions.assertNotNull(user.getCreatedAt());
        Assertions.assertNotNull(user.getUpdatedAt());
        Assertions.assertNull(user.getDeletedAt());
    }

    @Test
    void givenAnInvalidEmailEmptyParam_whenCallNewUser_thenShouldReceiveError() {
        final String name = "Test Name User";
        final String email = "";
        final String password = "fakepassword";
        final LocalDate birthDate = LocalDate.now();
        final Boolean isActive = true;


        final NotificationException actualException = Assertions.assertThrows(NotificationException.class, () -> {
            User.newUser(name, email, password, birthDate, isActive);
        });

        Assertions.assertEquals(1, actualException.getErrors().size());
        Assertions.assertEquals("Should be a valid e-mail!", actualException.getErrors().get(0));
    }

    @Test
    void givenAnInvalidEmailFormatParam_whenCallNewUser_thenShouldReceiveError() {
        final String name = "Test Name User";
        final String email = "test@";
        final String password = "fakepassword";
        final LocalDate birthDate = LocalDate.now();
        final Boolean isActive = true;

        final NotificationException actualException = Assertions.assertThrows(NotificationException.class, () -> {
            User.newUser(name, email, password, birthDate, isActive);
        });

        Assertions.assertEquals(1, actualException.getErrors().size());
        Assertions.assertEquals("Should be a valid e-mail!", actualException.getErrors().get(0));
    }

    @Test
    void givenABirthDateGreaterThan18_whenCallCanBuyAlcohol_thenShouldReturnTrue() {
        final String name = "Test Name User";
        final String email = "test@email.com";
        final String password = "fakepassword";
        final LocalDate birthDate = LocalDate.of(2000, 1, 1);
        final Boolean isActive = true;
        final User user = User.newUser(name, email, password, birthDate, isActive);

        Assertions.assertTrue(user.canBuyAlcohol());
    }


    @Test
    void givenABirthDateLowerThan18_whenCallCanBuyAlcohol_thenShouldReturnFalse() {
        final String name = "Test Name User";
        final String email = "test@email.com";
        final String password = "fakepassword";
        final LocalDate birthDate = LocalDate.now();
        final Boolean isActive = true;
        final User user = User.newUser(name, email, password, birthDate, isActive);

        Assertions.assertFalse(user.canBuyAlcohol());
    }
}

package com.churros.domain.user;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

import com.churros.domain.AggregateRoot;
import com.churros.domain.exceptions.NotificationException;
import com.churros.domain.validation.Notification;
import com.churros.domain.validation.ValidationHandler;

public class User extends AggregateRoot<UserID> {
    private UserID id;
    private String name;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
    private boolean active;
    private final Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(
            final UserID id,
            final String name,
            final String email,
            final String password,
            final LocalDate birthDate,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {

        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;

        selfValidate();
    }

    public void selfValidate() {
        final var notification = Notification.create();
        validate(notification);

        if (notification.hasError()) {
            throw new NotificationException("Failed to create a User", notification);
        }
    }

    public void validate(ValidationHandler handler) {
        new UserValidator(this, handler).validate();
    }


    public static User newUser(final UserID id, final String name, final String email, final String password,
                               final LocalDate birthDate,
                               final Boolean isActive) {
        final Instant now = Instant.now();
        final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;

        return new User(id, name, email, password, birthDate, isActive, now, now, deletedAt);
    }

    public static User newUser(final String name, final String email, final String password,
                               final LocalDate birthDate,
                               final Boolean isActive) {

        final UserID id = UserID.unique();
        final Instant now = Instant.now();
        final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;

        return new User(id, name, email, password, birthDate, isActive, now, now, deletedAt);
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthDate="
                + birthDate + ", active=" + active + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", deletedAt=" + deletedAt + "]";
    }


    public User activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = Instant.now();
        return this;
    }

    public User inactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public User update(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }


    public boolean canBuyAlcohol() {
        return Period.between(birthDate, LocalDate.now()).getYears() > 17;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
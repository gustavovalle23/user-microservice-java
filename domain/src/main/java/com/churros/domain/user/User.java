package com.churros.domain.user;

import java.time.Instant;
import java.time.LocalDate;

import com.churros.domain.AggregateRoot;
import com.churros.domain.validation.ValidationHandler;

public class User extends AggregateRoot<UserID> {
	private String name;
	private String email;
	private String password;
	private LocalDate birthDate;
	private boolean active;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;

	private User(UserID id, String name, String email, String password, LocalDate birthDate, boolean active,
			Instant createdAt, Instant updatedAt, Instant deletedAt) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public static User newUser(final String name, final String email, final String password, final LocalDate birthDate,
			final Boolean isActive) {
		final UserID id = UserID.unique();
		final Instant now = Instant.now();
		final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;

		return new User(id, name, email, password, birthDate, isActive, now, now, deletedAt);
	}

	@Override
	public void validate(ValidationHandler handler) {
		new UserValidator(this, handler).validate();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", active=" + active
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public User activate() {
		this.deletedAt = null;
		this.active = true;
		this.updatedAt = Instant.now();
		return this;
	}

	public User deactivate() {
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

}
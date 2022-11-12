package com.churros.domain.user;

import java.time.Instant;

import com.churros.domain.AggregateRoot;
import com.churros.domain.validation.ValidationHandler;

public class User extends AggregateRoot<UserID> {
	private String name;
	private String email;
	private String password;
	private Instant birthDate;
	private boolean active;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;

	public User(final UserID id, final String name, final String email, String password, final Instant birthDate) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
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

	public User update(final String name, final Boolean isActive) {
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

	public Instant getBirthDate() {
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
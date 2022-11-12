package com.churros.domain.user;

import java.util.Objects;
import java.util.UUID;

import com.churros.domain.Identifier;

public class UserID extends Identifier {
	private final String value;

	public UserID(final String value) {
		Objects.requireNonNull(value);
		this.value = value;
	}

	public static UserID unique() {
		return UserID.from(UUID.randomUUID());
	}

	public static UserID from(final UUID anId) {
		return new UserID(anId.toString().toLowerCase());
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserID other = (UserID) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

package com.churros.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(final String email) {
		super(email);
	}
}
package com.churros.domain.validation;

import com.churros.domain.exceptions.DomainException;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

	@Override
	public ValidationHandler append(final String anError) {
		throw DomainException.with(anError);
	}

	@Override
	public ValidationHandler append(final ValidationHandler anHandler) {
		throw DomainException.with(anHandler.getErrors());
	}

	@Override
	public <T> T validate(final Validation<T> aValidation) {
		try {
			return aValidation.validate();
		} catch (final Exception ex) {
			throw DomainException.with(ex.getMessage());
		}
	}

	@Override
	public List<String> getErrors() {
		return List.of();
	}
}

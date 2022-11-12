package com.churros.domain.user;

import com.churros.domain.validation.Error;
import com.churros.domain.validation.ValidationHandler;
import com.churros.domain.validation.Validator;

public class UserValidator extends Validator {

	private final User user;

	protected UserValidator(final User user, ValidationHandler handler) {
		super(handler);
		this.user = user;
	}

	@Override
	public void validate() {
		if (this.user.getEmail().length() == 0)
			this.validationHandler().append(new Error("Should be a valid e-mail!"));
	}
}

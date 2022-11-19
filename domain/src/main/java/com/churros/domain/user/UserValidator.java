package com.churros.domain.user;

import java.util.regex.Pattern;

import com.churros.domain.validation.Error;
import com.churros.domain.validation.ValidationHandler;
import com.churros.domain.validation.Validator;

public class UserValidator extends Validator {

	private final User user;
	private final Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	protected UserValidator(final User user, ValidationHandler handler) {
		super(handler);
		this.user = user;
	}

	@Override
	public void validate() {
		if (!this.pattern.matcher(this.user.getEmail()).find())
			this.validationHandler().append(new Error("Should be a valid e-mail!"));
	}
}

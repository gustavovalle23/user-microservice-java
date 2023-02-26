package com.churros.domain.exceptions;

import com.churros.domain.validation.Error;

import java.util.Collection;
import java.util.List;

public class DomainException extends NoStacktraceException {

    protected final List<String> errors;

    protected DomainException(final String aMessage, final List<String> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final String anErrors) {
        return new DomainException(anErrors, List.of(anErrors));
    }

    public static DomainException with(final List<String> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<String> getErrors() {
        return errors;
    }

}

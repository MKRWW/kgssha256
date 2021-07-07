package com.voidmain.jobinterview.kgs.sha256.exception;

import javax.annotation.Nonnull;

/**
 * Exception class which is used in parameter validation
 *
 * @author Markus Kremer
 */
public class ParameterValidationException extends Throwable {

    public ParameterValidationException(@Nonnull final String message) {
        super(message);
    }

}

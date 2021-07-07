package com.voidmain.jobinterview.kgs.sha256.services.impl;

import com.voidmain.jobinterview.kgs.sha256.exception.ParameterValidationException;
import com.voidmain.jobinterview.kgs.sha256.services.IParameterValidatorService;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Validates the command line parameters
 *
 * @author Markus Kremer
 */
public class CommandLineParameterValidatorService implements IParameterValidatorService {

    public static final int MINIMUM_PARAMETERS_COUNT = 2;

    /**
     * Validates parameters coming in from the commandline
     *
     * @param parameters A List of parameters
     * @throws ParameterValidationException Is thrown when there are no parameters at all or the amount is not correct (2 parameters required).
     */
    @Override
    public void validateParameters(@Nonnull List<String> parameters) throws ParameterValidationException {
        if(MINIMUM_PARAMETERS_COUNT != parameters.size()){
           throw new ParameterValidationException("You should provide an input and output filename as parameters: \"java -jar sha256-1.0-SNAPSHOT-shaded.jar in.put out.put\"");
        }
    }

}

package com.voidmain.jobinterview.kgs;

import com.voidmain.jobinterview.kgs.exception.ParameterValidationException;
import com.voidmain.jobinterview.kgs.model.Hash;
import com.voidmain.jobinterview.kgs.repositories.IDataRepository;
import com.voidmain.jobinterview.kgs.repositories.impl.FileRepository;
import com.voidmain.jobinterview.kgs.services.IHashService;
import com.voidmain.jobinterview.kgs.services.IParameterValidatorService;
import com.voidmain.jobinterview.kgs.services.impl.CommandLineParameterValidatorService;
import com.voidmain.jobinterview.kgs.services.impl.SHA256HashService;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Entrypointclass for a typical console application
 *
 * @author Markus Kremer
 */
public class KgsSHA256ConsoleApplication {

    final static Logger LOG = Logger.getLogger(KgsSHA256ConsoleApplication.class);

    final static IDataRepository inputDataRepository = new FileRepository();

    final static IDataRepository outputDataRepository = new FileRepository();

    final static IHashService hashService = new SHA256HashService();

    final static IParameterValidatorService parameterValidatorService = new CommandLineParameterValidatorService();

    /**
     * The one and only main method
     *
     * @param args here come the commandline arguments
     */
    public static void main(String[] args) {
        LOG.info("KGS-SHA256 Hash generator.....");
        final List<String> parameters = Collections.unmodifiableList(Arrays.asList(args));
        try {
            parameterValidatorService.validateParameters(parameters);
            final File inputFile = new File(args[0]);
            final File outputFile = new File(args[1]);
            inputDataRepository.attach(inputFile.toURI());
            outputDataRepository.attach(outputFile.toURI());
            final Hash generatedHash = hashService.generateHash(inputDataRepository, outputDataRepository);
            outputDataRepository.save(generatedHash);
            outputDataRepository.detach();
            inputDataRepository.detach();
        } catch (ParameterValidationException parameterValidationException) {
            LOG.error("OOPS: wrong parameters. Root Cause is: " + parameterValidationException.getMessage());
        } catch (MalformedURLException malformedURLException){
            LOG.error("OOPS: WTF did you provide as input and/or output path. Are you kidding me?");
        } catch (IOException ioException) {
            LOG.error("OOPS: input and/or output file cannot be read. Check if file is present and you provided the correct path");
        }
    }
}

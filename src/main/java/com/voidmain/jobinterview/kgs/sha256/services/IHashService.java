package com.voidmain.jobinterview.kgs.sha256.services;

import com.voidmain.jobinterview.kgs.sha256.model.Hash;
import com.voidmain.jobinterview.kgs.sha256.repositories.IDataRepository;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface IHashService {
    /**
     * Generates the hash from an inputDataRepository and returns it.
     *
     * @param inputDataRepository The inputDataRepository
     * @return A hash or null if has was not generated
     * @throws NoSuchAlgorithmException If something is wrong with crypto
     * @throws IOException              If data could not be obtained from inputDataRepository
     */
    @CheckForNull
    Hash generateHash(@Nonnull final IDataRepository inputDataRepository) throws NoSuchAlgorithmException, IOException;
}

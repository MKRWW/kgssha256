package com.voidmain.jobinterview.kgs.services.impl;

import com.voidmain.jobinterview.kgs.model.Hash;
import com.voidmain.jobinterview.kgs.repositories.IDataRepository;
import com.voidmain.jobinterview.kgs.services.IHashService;
import com.voidmain.jobinterview.kgs.util.ByteArrayHexStringConverter;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * The hash service which actually does the sha256 hashing
 *
 * @author Markus Kremer
 */
public class SHA256HashService implements IHashService {
    /**
     * Generates the hash from an inputDataRepository and returns it.
     *
     * @param inputDataRepository The inputDataRepository
     * @return A hash or null if has was not generated
     *
     * @throws NoSuchAlgorithmException If something is wrong with crypto
     * @throws IOException If data could not be obtained from inputDataRepository
     */
    @CheckForNull
    @Override
    public Hash generateHash(@Nonnull IDataRepository inputDataRepository) throws NoSuchAlgorithmException, IOException {
        final MessageDigest messageDigestService = MessageDigest.getInstance("SHA3-256");
        final byte[] hashData = messageDigestService.digest(inputDataRepository.read());
        if (null == hashData) {
            return null;
        }
        final String hexString = ByteArrayHexStringConverter.convert(hashData);
        return new Hash(hexString, Instant.now());
    }
}

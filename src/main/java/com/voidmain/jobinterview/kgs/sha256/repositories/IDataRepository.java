package com.voidmain.jobinterview.kgs.sha256.repositories;

import com.voidmain.jobinterview.kgs.sha256.model.Hash;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.URI;

/**
 * Interface of the Data Repository we need for Input-Output
 *
 * @author Markus Kremer
 */
public interface IDataRepository {
    /**
     * Attaches to a input or output datasource
     *
     * @param uri The url to the source
     * @param isSource Determines if we have a source or destination repo.
     * @throws IOException Is thrown when the source could not be opened
     */
    void attach(@Nonnull final URI uri, final boolean isSource) throws IOException;

    /**
     * detaches from a datasource
     */
    void detach();

    /**
     * Saves a hash to a datasource
     * @param generatedHash The hash itself. nothing will be saved if the hash is null.
     * @throws IOException If data could not be written.
     */
    void save(final @CheckForNull Hash generatedHash) throws IOException;

    /**
     * Read Data from a source
     * @return Returns a byte array containing raw data.
     * @throws IOException Is thrown if data could not be read.
     */
    @Nonnull byte[] read() throws IOException;
}

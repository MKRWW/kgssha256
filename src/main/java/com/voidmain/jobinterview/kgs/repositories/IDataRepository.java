package com.voidmain.jobinterview.kgs.repositories;

import com.voidmain.jobinterview.kgs.model.Hash;

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
     * @throws IOException Is thrown when the source could not be opened
     */
    void attach(@Nonnull final URI uri) throws IOException;

    /**
     * detaches from a datasource
     */
    void detach();

    /**
     * Saves a hash to a datasource
     * @param generatedHash The hash itself. nothing will be saved if the hash is null.
     */
    void save(final @CheckForNull Hash generatedHash);
}

package com.voidmain.jobinterview.kgs.repositories.impl;

import com.voidmain.jobinterview.kgs.model.Hash;
import com.voidmain.jobinterview.kgs.repositories.IDataRepository;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.URI;

public class FileRepository implements IDataRepository {
    @Override
    public void attach(@Nonnull URI toURI) throws IOException {

    }

    @Override
    public void detach() {

    }

    @Override
    public void save(@CheckForNull Hash generatedHash) {

    }
}

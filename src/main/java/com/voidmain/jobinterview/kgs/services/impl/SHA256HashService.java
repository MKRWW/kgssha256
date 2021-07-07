package com.voidmain.jobinterview.kgs.services.impl;

import com.voidmain.jobinterview.kgs.model.Hash;
import com.voidmain.jobinterview.kgs.repositories.IDataRepository;
import com.voidmain.jobinterview.kgs.services.IHashService;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class SHA256HashService  implements IHashService {
    @CheckForNull
    @Override
    public Hash generateHash(@Nonnull IDataRepository inputDataRepository, @Nonnull IDataRepository outputDataRepository) {
        return null;
    }
}

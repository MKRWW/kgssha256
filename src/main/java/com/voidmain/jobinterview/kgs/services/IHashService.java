package com.voidmain.jobinterview.kgs.services;

import com.voidmain.jobinterview.kgs.model.Hash;
import com.voidmain.jobinterview.kgs.repositories.IDataRepository;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public interface IHashService {
    @CheckForNull Hash generateHash(@Nonnull final IDataRepository inputDataRepository, @Nonnull final IDataRepository outputDataRepository);
}

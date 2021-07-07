package com.voidmain.jobinterview.kgs.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

/**
 * The Model which holds the hash and a timestamp when the hash was created.
 */
@Data
@RequiredArgsConstructor
public class Hash {

    private final @NonNull String hashValue;
    private @NonNull Instant creationTimestamp;

}

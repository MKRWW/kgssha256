package com.voidmain.jobinterview.kgs.util;

import javax.annotation.Nonnull;

/**
 * A small converter class which converts a byte array into a hex string.
 *
 * @author Markus Kremer
 */
public class ByteArrayHexStringConverter {

    /**
     * Converts a byte array into a nice formatted hexadecimal string.
     * @param hash The data as byte array which shall be converted into a string.
     * @return A String object containing the hex string.
     */
    @Nonnull
    public static String convert(@Nonnull final byte[] hash) {
        final StringBuilder target = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hexValue = Integer.toHexString(0xff & hash[i]);
            if (hexValue.length() == 1) {
                target.append('0');
            }
            target.append(hexValue);
        }
        return target.toString();
    }
}

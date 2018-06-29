package com.scent.core.util;

import java.util.Map;

import static com.scent.core.util.Constants.EMPTY;
import static com.scent.core.util.Constants.INDEX_NOT_FOUND;
import static com.scent.core.util.Constants.NULL;

public class StringUtil {

    /**
     * no arg constructor
     */
    private StringUtil() {
        super();
    }
    /**
     * Null-safe check if the specified map is empty.
     * Null returns true.
     *
     * @param map  the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(Map map) {
        return (map == null || map.isEmpty());
    }


    /**
     * Check if the given string is null, empty or all spaces.
     *
     * @param value
     *            string to check
     * @return true if the string is null or trimmed has zero length.
     */
    public static boolean isNullTrimmedString(String value) {
        return value == null || isEmpty(value.trim()) || isBlank(value.trim())
                || NULL.equalsIgnoreCase(value);
    }

    /**
     * Checks if a CharSequence is whitespace, empty ("") or null.
     * isBlank(null)      = true
     * isBlank("")        = true
     * isBlank(" ")       = true
     * isBlank("bob")     = false
     * isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(cs.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Checks if a CharSequence is empty ("") or null.</p>
     *
     * <pre>
     * isEmpty(null)      = true
     * isEmpty("")        = true
     * isEmpty(" ")       = false
     * isEmpty("bob")     = false
     * isEmpty("  bob  ") = false
     * </pre>
     *
     * <p>NOTE: This method changed in Lang version 2.0.
     * It no longer trims the CharSequence.
     * That functionality is available in isBlank().</p>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is empty or null
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * <p>Gets the substring before the first occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A {@code null} string input will return {@code null}.
     * An empty ("") string input will return the empty string.
     * A {@code null} separator will return the input string.</p>
     *
     * <p>If nothing is found, the string input is returned.</p>
     *
     * <pre>
     * substringBefore(null, *)      = null
     * substringBefore("", *)        = ""
     * substringBefore("abc", "a")   = ""
     * substringBefore("abcba", "b") = "a"
     * substringBefore("abc", "c")   = "ab"
     * substringBefore("abc", "d")   = "abc"
     * substringBefore("abc", "")    = ""
     * substringBefore("abc", null)  = "abc"
     * </pre>
     *
     * @param str  the String to get a substring from, may be null
     * @param separator  the String to search for, may be null
     * @return the substring before the first occurrence of the separator,
     *  {@code null} if null String input
     */
    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * <p>Joins the elements of the provided array into a single String
     * containing the provided list of elements.</p>
     *
     * <p>No delimiter is added before or after the list.
     * A {@code null} separator is the same as an empty String ("").
     * Null objects or empty strings within the array are represented by
     * empty strings.</p>
     *
     * <pre>
     * join(null, *)                = null
     * join([], *)                  = ""
     * join([null], *)              = ""
     * join(["a", "b", "c"], "--")  = "a--b--c"
     * join(["a", "b", "c"], null)  = "abc"
     * join(["a", "b", "c"], "")    = "abc"
     * join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param array  the array of values to join together, may be null
     * @param separator  the separator character to use, null treated as ""
     * @return the joined String, {@code null} if null array input
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }


    /**
     * <p>Joins the elements of the provided array into a single String
     * containing the provided list of elements.</p>
     *
     * <p>No delimiter is added before or after the list.
     * A {@code null} separator is the same as an empty String ("").
     * Null objects or empty strings within the array are represented by
     * empty strings.</p>
     *
     * <pre>
     * join(null, *)                = null
     * join([], *)                  = ""
     * join([null], *)              = ""
     * join(["a", "b", "c"], "--")  = "a--b--c"
     * join(["a", "b", "c"], null)  = "abc"
     * join(["a", "b", "c"], "")    = "abc"
     * join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param array  the array of values to join together, may be null
     * @param separator  the separator character to use, null treated as ""
     * @param startIndex the first index to start joining from.  It is
     * an error to pass in an end index past the end of the array
     * @param endIndex the index to stop joining from (exclusive). It is
     * an error to pass in an end index past the end of the array
     * @return the joined String, {@code null} if null array input
     */
    private static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = EMPTY;
        }

        // endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
        //           (Assuming that all Strings are roughly equally long)
        int noOfItems = (endIndex - startIndex);
        if (noOfItems <= 0) {
            return EMPTY;
        }

        StringBuilder buf = new StringBuilder(noOfItems * 16);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }


    /**
     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
     *
     * <pre>
     * isNotBlank(null)      = false
     * isNotBlank("")        = false
     * isNotBlank(" ")       = false
     * isNotBlank("bob")     = true
     * isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is
     *  not empty and not null and not whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isNotBlank(String) to isNotBlank(CharSequence)
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

}

package com.scent.core.util;

import org.owasp.esapi.ESAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.scent.core.util.Constants.*;


/**

 *
 */
public final class XssSanitizerUtil {
    // XSS Constants

    /**
     * Creating pattern to remove unsecured data from parameters.
     */
    private static Pattern[] xssPatterns = new Pattern[] {
            // Script fragments
            Pattern.compile(CASE_INSENSITIVE, Pattern.CASE_INSENSITIVE),
            // src='...'
            Pattern.compile(CASE_INSENSITIVE_MULTILINE_DOTALL_WITH_SINGLE_QUOTE,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile(CASE_INSENSITIVE_MULTILINE_DOTALL_WITH_DOUBLE_QUOTE,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // lonely script tags
            Pattern.compile(SCRIPT_CASE_INSENSITIVE, Pattern.CASE_INSENSITIVE),
            Pattern.compile(SCRIPT_CASE_INSENSITIVE_MULTILINE_DOTALL,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // eval(...)
            Pattern.compile(EVAL_CASE_INSENSITIVE_MULTILINE_DOTALL,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // expression(...)
            Pattern.compile(EXPRESSION_CASE_INSENSITIVE_MULTILINE_DOTALL,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // javascript:...
            Pattern.compile(JAVA_SCRIPT_CASE_INSENSITIVE, Pattern.CASE_INSENSITIVE),
            // vbscript:...
            Pattern.compile(VB_SCRIPT_CASE_INSENSITIVE, Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile(ONLOAD_CASE_INSENSITIVE_MULTILINE,
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL) };

    private XssSanitizerUtil() {
        super();
    }



    /**
     * Check if the given string is null, empty or all spaces.
     *
     * @param value
     *            string to check
     * @return true if the string is null or trimmed has zero length.
     */
    public static boolean isNullTrimmedString(String value) {
        return value == null || StringUtil.isEmpty(value.trim()) || StringUtil.isBlank(value.trim())
                || NULL.equalsIgnoreCase(value);
    }

    /**
     * Removing unsecured data from passed parameters
     * 
     * @param value
     *            URL on which you want to apply security. Example -
     *            "/v_images/marlboro-ugc/ctu/gallery/".
     * @return value Filtered URL.
     */
    public static String stripXSS(String value) {
        String stripedString = "";
        if (StringUtil.isNullTrimmedString(value) || value.contains(HTTP) || value.contains(HTTPS)
                || value.contains(AMPERSAND)) {
            stripedString = value;
        } else {
            // NOTE: It's highly recommended to use the ESAPI library and
            // uncomment the following line to
            // avoid encoded attacks.

            stripedString = ESAPI.encoder().canonicalize(value);

            // Avoid null characters
            stripedString = stripedString.replaceAll(NULL_STRING, EMPTY);
            // Remove all sections that match a pattern
            for (Pattern scriptPattern : xssPatterns) {
                stripedString = scriptPattern.matcher(stripedString).replaceAll(EMPTY);
            }

        }

        return stripedString;
    }

    /**
     * Removing unsecured data from passed map
     * 
     * @param map
     *            all map values are sanitizing
     * 
     * @return resultMap.
     */
    public static Map<String, String> stripXSSMap(Map<String, String> map) {
        Map<String, String> resultMap = new HashMap<>();

        if (StringUtil.isEmpty(map)) {
            return map;
        } else {
            map.forEach((k, v) -> resultMap.put(k, XssSanitizerUtil.stripXSS(v)));
        }
        return resultMap;
    }


}

package com.scent.util;

import com.scent.core.metadata.TestMetaData;


import static com.scent.core.util.StringUtil.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@TestMetaData
public class StringUtilTest {
    @Test
    public void testMapIsEmptyNull(){
        Map map = new HashMap<>();
        assertTrue(isEmpty(map));

        map.put("Hello", "Hello");
        assertFalse(isEmpty(map));
        map =null;
        assertTrue(isEmpty(map));
    }
    @Test
    public void testIsNullTrimmedString(){
        String value = "";
        assertTrue(isNullTrimmedString(value));
        value = " ";
        assertTrue(isNullTrimmedString(value));
    }

    @Test
    public void testIsBlank(){
        assertTrue(isBlank(null));
        assertTrue(isBlank(""));
        assertTrue(isBlank(" "));
        assertFalse(isBlank("bob"));
        assertFalse(isBlank("  bob  "));
    }
    @Test
    public void testIsEmpty(){
        String value =null;
        assertTrue(isEmpty(value));
        assertTrue(isEmpty(""));
        assertFalse(isEmpty(" "));
        assertFalse(isEmpty("bob"));
        assertFalse(isEmpty("  bob  "));
    }
    @Test
    public void testSubStringBefore(){
        assertNull(substringBefore(null, "*") );
        assertEquals("", substringBefore("", "*"));
        assertEquals("", substringBefore("abc", "a"));
        assertEquals("a", substringBefore("abcba", "b"));
        assertEquals("ab", substringBefore("abc", "c"));
        assertEquals("abc", substringBefore("abc", "d"));
        assertEquals("", substringBefore("abc", ""));
        assertEquals("abc", substringBefore("abc", null));
    }

    @Test
    public void testNotBlanck() {
        assertFalse(isNotBlank(null));
        assertFalse(isNotBlank(""));
        assertFalse(isNotBlank(" "));
        assertTrue(isNotBlank("bob"));
        assertTrue(isNotBlank("  bob  "));
    }

    @Test
    public void testJoin() {
        assertNull(join(null, "*"));
        assertEquals("", join(new Object[0], "*"));
        assertEquals("", join(new Object[]{null}, "*"));
        assertEquals("a--b--c", join(new Object[]{"a", "b", "c"}, "--"));
        assertEquals("abc", join(new Object[]{"a", "b", "c"}, null));
        assertEquals("abc", join(new Object[]{"a", "b", "c"}, ""));
        assertEquals(",,a", join(new Object[]{null, "", "a"}, ","));
    }
}

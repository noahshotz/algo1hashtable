package com.algo1hashtable;

import programmierPflicht.Hashtable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {

    // test if initial insert of key returns null
    @Test
    void testPut01(){
        // create new hashtable
        Hashtable newHashtable = new Hashtable();
        String actual = newHashtable.put(2, "23");

        assertNull(actual);
    }

    // test if inserting with duplicate key returns overwritten value
    @Test
    void testPut02(){
        // create new hashtable
        Hashtable newHashtable = new Hashtable();
        newHashtable.put(2, "23");
        String actual = newHashtable.put(2, "34");

        assertEquals("23", actual);
    }

    // test return value on returned value for specific key (key: 3)
    @Test
    void testGet01() {

        // create new hashtable
        Hashtable newHashtable = new Hashtable();

        // initial insert of values into hashtable
        newHashtable.put(2, "23");
        newHashtable.put(2, "34");
        newHashtable.put(2, "78");
        newHashtable.put(3, "58");
        newHashtable.put(6, "61");
        newHashtable.put(6, "17");
        newHashtable.put(8, "85");
        newHashtable.put(24, "100");

        // get value from hashtable at key 2
        String actual = newHashtable.get(3);

        assertEquals("58", actual);
    }

    // test return value on duplicate keys (key: 2)
    @Test
    void testGet02() {

        // create new hashtable
        Hashtable newHashtable = new Hashtable();

        // initial insert of values into hashtable
        newHashtable.put(2, "23");
        newHashtable.put(2, "34");
        newHashtable.put(2, "78");
        newHashtable.put(3, "58");
        newHashtable.put(6, "61");
        newHashtable.put(6, "17");
        newHashtable.put(8, "85");
        newHashtable.put(24, "100");

        // get value from hashtable at key 2
        String actual = newHashtable.get(2);

        assertEquals("78", actual);
    }

    // test return value when trying to get non-existent key (15)
    @Test
    void testGet03() {

        // create new hashtable
        Hashtable newHashtable = new Hashtable();

        // initial insert of values into hashtable
        newHashtable.put(2, "23");
        newHashtable.put(2, "34");
        newHashtable.put(2, "78");
        newHashtable.put(3, "58");
        newHashtable.put(6, "61");
        newHashtable.put(6, "17");
        newHashtable.put(8, "85");
        newHashtable.put(24, "100");

        // get value from hashtable at key 2
        String actual = newHashtable.get(15);

        assertNull(actual);
    }

    // test if removing entry for non-existent key returns null
    @Test
    void testRemove01() {

        // create new hashtable
        Hashtable newHashtable = new Hashtable();

        // initial insert of values into hashtable
        newHashtable.put(2, "23");
        newHashtable.put(2, "34");
        newHashtable.put(2, "78");
        newHashtable.put(3, "58");
        newHashtable.put(6, "61");
        newHashtable.put(6, "17");
        newHashtable.put(8, "85");
        newHashtable.put(24, "100");

        // get value from hashtable at key 2
        String actual = newHashtable.remove(15);

        assertNull(actual);
    }

    // test if removing entry for key returns correct value
    @Test
    void testRemove02() {

        // create new hashtable
        Hashtable newHashtable = new Hashtable();

        // initial insert of values into hashtable
        newHashtable.put(2, "23");
        newHashtable.put(2, "34");
        newHashtable.put(2, "78");
        newHashtable.put(3, "58");
        newHashtable.put(6, "61");
        newHashtable.put(6, "17");
        newHashtable.put(8, "85");
        newHashtable.put(24, "100");

        // get value from hashtable at key 2
        String actual = newHashtable.remove(2);

        assertEquals("78", actual);
    }
}

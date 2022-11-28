package com.algo1hashtable;

import programmierPflicht.*;

public class Main {
    public static void main(String[] args) {
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

        // return hashtable initial fill
        newHashtable.returnHashtable(); 

        // get value from hashtable at key 2
        newHashtable.get(2);

        // remove value at key 2 from hashtable
        newHashtable.remove(2);

        newHashtable.remove(15);
        // return hashtable after value has been removed
        newHashtable.returnHashtable();

    }
}


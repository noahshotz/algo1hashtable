package programmierPflicht;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Hashtable implements IntStringMap {

    // k sets length of hashtable and mod factor
    private int k;
    private LinkedList<Entry<Integer, String>>[] hashtable;

    // constructor
    @SuppressWarnings({"unchecked"})
    public Hashtable(int n) {
        k = n;
        hashtable = new LinkedList[k];
    }

    // helper to pretty-print hashtable
    public void returnHashtable() {
        String returnHashtable = "";

        for (int i = 0; i < hashtable.length; i++) {
            returnHashtable += "Index " + i + ": " + hashtable[i] + "\n";
        }
        System.out.println("---------------");
        System.out.println(returnHashtable);
        System.out.println("---------------");
    }

    // hash keys using mod function
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // store key-value-pairs in linkedlist
    static class KeyValuePair {
        public static KeyValuePair newEntry;

        public static Entry<Integer, String> newEntry(Integer key, String value) {
            Map.Entry<Integer, String> newEntry = new AbstractMap.SimpleEntry<Integer, String>(key, value);
            return newEntry;
        }
    }

    // put-method
    public String put(Integer key, String value) {

        // apply hash function on key
        int hashedKey = hashCode(key, k);

        // create new linkedlist if none exists at index
        // index = hashed key
        boolean keyExists = false;
        if (hashtable[hashedKey] == null) {
            hashtable[hashedKey] = new LinkedList<Entry<Integer, String>>();
            hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
        } else {
            // overwrite value if keys are duplicate
            int i = 0;
            Map.Entry<Integer, String> hashtableItem = hashtable[hashedKey].get(i);
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtableItem.getKey() == key) {
                    keyExists = true;
                    // store removed value
                    String removedValue = hashtableItem.getValue();
                    hashtable[hashedKey].set(
                            // entry position
                            i,
                            // entry value
                            KeyValuePair.newEntry(key, value));
                    return removedValue;
                }
            }
            // add key & value if key does not exist yet
            if (!keyExists) {
                hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
            }
        }
        return null;
    }

    // get-method
    public String get(Integer key) {
        int hashedKey = hashCode(key, k);
        String getValue = null;
        if (hashtable[hashedKey] != null) {
            int i = 0;
            Map.Entry<Integer, String> hashtableItem = hashtable[hashedKey].get(i);
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtableItem.getKey() == key) {
                    getValue = hashtableItem.getValue();
                }
            }
        } else {
            return null;
        }
        if (getValue == null) {
            return null;
        } else {
            System.out.println("Matching value for key " + key + ": " + getValue + "\n");
            return getValue;
        }
    }

    // remove-method
    public String remove(Integer key) {
        int hashedKey = hashCode(key, k);
        String removedValue = null;
        int i = 0;
        if (hashtable[hashedKey] != null) {
            Map.Entry<Integer, String> hashtableItem = hashtable[hashedKey].get(i);
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtableItem.getKey() == key) {
                    removedValue = hashtableItem.getValue();
                    hashtable[hashedKey].remove(i);
                }
            }
        } else {
            return null;
        }
        if (removedValue == null) {
            return null;
        } else {
            System.out.println("Removed value for key " + key + ": " + removedValue);
            return removedValue;
        }
    }
}

package programmierPflicht;

import java.util.LinkedList;
import java.util.Map;

public class Hashtable implements IntStringMap {

    // k sets length of hashtable and mod factor
    private int k;
    private LinkedList<KeyValuePair>[] hashtable;

    // constructor
    @SuppressWarnings({"unchecked"})
    public Hashtable(int n) {
        k = n;
        hashtable = new LinkedList[k];
    }

    class KeyValuePair implements Map.Entry<Integer, String> {
        private Integer key;
        private String value;

        public KeyValuePair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            this.value = value;
            return value;
        }
    }
    private KeyValuePair KeyValuePair(Integer key, String value) {
        return new KeyValuePair(key, value);
    }

    // helper to pretty-print hashtable
    public void returnHashtable() {
        String returnHashtable = "";
        for (int x = 0; x < hashtable.length; x++) {
            if (hashtable[x] != null) {
                returnHashtable += "hashtable[" + x + "] = ";
                for (int z = 0; z < hashtable[x].size(); z++) {
                    returnHashtable +=
                    "["
                    + hashtable[x].get(z).getKey() 
                    + "=" 
                    + hashtable[x].get(z).getValue()
                    + "]";
                }
                returnHashtable += " \n";
            } else {
                returnHashtable += "hashtable[" + x + "] = [null]" + "\n";
            }
        }
        System.out.println(returnHashtable);
    }

    // hash keys using mod function
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // put-method
    public String put(Integer key, String value) {

        // apply hash function on key
        int hashedKey = hashCode(key, k);

        // create new linkedlist if none exists at index
        // index = hashed key
        boolean keyExists = false;
        if (hashtable[hashedKey] == null) {
            hashtable[hashedKey] = new LinkedList<KeyValuePair>();
            hashtable[hashedKey].addLast(KeyValuePair(key, value));
        } else {
            // overwrite value if keys are duplicate
            int i = 0;
            KeyValuePair hashtableItem = hashtable[hashedKey].get(i);
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtableItem.getKey() == key) {
                    keyExists = true;
                    // store removed value
                    String removedValue = hashtableItem.getValue();
                    hashtable[hashedKey].set(
                            // entry position
                            i,
                            // entry value
                            KeyValuePair(key, value));
                    return removedValue;
                }
            }
            // add key & value if key does not exist yet
            if (!keyExists) {
                hashtable[hashedKey].addLast(KeyValuePair(key, value));
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
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                KeyValuePair hashtableItem = hashtable[hashedKey].get(i);
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
            System.out.println("Received value for key " + key + ": " + getValue + "\n");
            return getValue;
        }
    }

    // remove-method
    public String remove(Integer key) {
        int hashedKey = hashCode(key, k);
        String removedValue = null;
        int i = 0;
        if (hashtable[hashedKey] != null) {
            for (i = 0; i < hashtable[hashedKey].size(); i++) {
                KeyValuePair hashtableItem = hashtable[hashedKey].get(i);
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
            System.out.println("Removed value for key " + key + ": " + removedValue +  "\n");
            return removedValue;
        }
    }
}

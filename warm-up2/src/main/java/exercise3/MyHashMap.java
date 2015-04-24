package exercise3;

import java.util.*;

/**
 * Created by Andrei on 4/24/2015.
 */
public class MyHashMap<K, V> {
    private ArrayList<LinkedList<MyEntry<K, V>>> values;

    public MyHashMap() {
        values = new ArrayList<LinkedList<MyEntry<K, V>>>();
        for (int i = 0; i < 16; i++) {
            values.add(i, new LinkedList<MyEntry<K, V>>());
        }
    }

    public V get(K key) {
        int x = key.hashCode() % 17;
        for (int j = 0; j < values.get(x).size(); j++) {
            if (values.get(x).get(j) != null) {
                if (values.get(x).get(j).getKey().equals(key)) {
                    System.out.print(values.get(x).get(j).getValue());
                    return values.get(x).get(j).getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int x = key.hashCode() % 17;
        if (values.get(x).isEmpty()) {
            values.get(x).add(new MyEntry<K, V>(key, value));
        } else {
            boolean exists = false;
            for (int i = 0; i < values.get(x).size(); i++)
                if (values.get(x).get(i).getKey().equals(key) || values.get(x).get(i).equals(null)) {
                    exists = true;
                    values.get(x).get(i).setValue(value);
                }
            if (exists == false) {
                values.get(x).add(new MyEntry<K, V>(key, value));
            }
        }
    }


    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(i).size(); j++) {
                set.add(values.get(i).get(j).getKey());
            }
        }
        return set;
    }

    public Set<V> entrySet() {
        Set<V> set = new HashSet<V>();
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(i).size(); j++) {
                set.add(values.get(i).get(j).getValue());
            }
        }
        return set;
    }
}

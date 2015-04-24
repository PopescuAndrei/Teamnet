package exercise3;

import java.util.Map;

/**
 * Created by Andrei on 4/24/2015.
 */
public class TestMyHashMap {

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHm = new MyHashMap<Integer, String>();
        myHm.put(1, "Unu");
        myHm.put(2, "Doi");
        myHm.put(2, "Trei");
        myHm.put(2, "Doi");
        myHm.put(3, "Douazeci");

        for (Integer i : myHm.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (String s : myHm.entrySet()) {
            System.out.print(s + " ");
        }

    }
}

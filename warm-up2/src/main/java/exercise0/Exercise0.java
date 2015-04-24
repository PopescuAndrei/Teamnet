package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p/>
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 * print all its elements.
 */
public class Exercise0 {

    public Exercise0() {

    }

    public void iterateThroughMap() {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 10);
        map.put(3, 22);
        map.put(4, 200);

        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            System.out.print(mapEntry.getKey() + " = " + mapEntry.getValue());
        }

        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]

    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}

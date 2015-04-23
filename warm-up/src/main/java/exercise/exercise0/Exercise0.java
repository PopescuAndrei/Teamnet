package exercise.exercise0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p/>
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 * for loop and foreach loop.
 */
public class Exercise0 {

    public Exercise0() {

    }

    public void iterateThroughList() {

        List<Integer> firstList = new ArrayList<Integer>();
        firstList.add(2);
        firstList.add(3);

        Iterator<Integer> iterator = firstList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        for (int i = 0; i < firstList.size(); i++) {
            System.out.print(firstList.get(i) + " ");
        }
        System.out.println();
        for (Integer integer : firstList) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughList();
    }
}

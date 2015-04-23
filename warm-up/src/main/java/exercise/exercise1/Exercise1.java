package exercise.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p/>
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 * different ways to iterate over a List:
 * a) ListIterator (implement it in the iterateUsingListIterator() method)
 * b) for loop (implement it in the iterateUsingForLoop() method)
 * c) foreach loop (implement it in the iterateUsingForEachLoop() method)
 * <p/>
 * In order to test your implementations you need to run the Exercise1Test from the test/java package
 * (right-click on Exercise1Test class, then click Run 'Exercise1Test' )
 */
public class Exercise1 {

    // The list that contains some Integer values
    private List<Integer> givenList;

    public Exercise1(List<Integer> l) {
        this.givenList = l;
    }

    // TODO Exercise #1 a) Compute sum and get the min and the max from givenList, iterating through it using ListIterator
    public List<Integer> iterateUsingListIterator() {

        // This List is used only for testing so you don't have to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        ListIterator<Integer> iterator = givenList.listIterator();
        int sum = 0;
        int min = 32000;
        int max = -32000;
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            sum = sum + integer;
            if (integer < min) {
                min = integer;
            }
            if (integer > max) {
                max = integer;
            }

        }
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 b) Compute sum and get the min and the max from list, iterating through it using classic for loop
    public List<Integer> iterateUsingForLoop() {

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int min = 32000;
        int max = -32000;
        int sum = 0;
        for (int i = 0; i < givenList.size(); i++) {
            sum += givenList.get(i);
            if (givenList.get(i) < min) {
                min = givenList.get(i);
            }
            if (givenList.get(i) > max) {
                max = givenList.get(i);
            }
        }
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 c) Compute sum and get the min and the max from list iterating through it using foreach loop
    public List<Integer> iterateUsingForEachLoop() {

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int min = 32000;
        int max = -32000;
        int sum = 0;
        for (Integer v : givenList) {
            sum += v;
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    public static void main(String[] args) {

    }
}

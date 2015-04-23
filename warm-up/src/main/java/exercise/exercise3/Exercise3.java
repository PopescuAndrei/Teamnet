package exercise.exercise3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Radu.Hoaghe on 04/20/2015.
 * <p/>
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 * the earlier presentation) with the List<String> that is given to this class by
 * its constructor.
 * <p/>
 * Check out the elements that the list mentioned above contains and then, add them
 * to your three Sets. After this, check out the elements of your Sets. What do you
 * remark? What could be the reason?
 * <p/>
 * Finally, add to the one of the three Sets some elements
 * that already exist in the Set (e.g add("that") and add("collection"))
 * <p/>
 * To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets() {

        System.out.println("The elements that will be added to the Sets: " + listToAdd.toString());

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        HashSet<String> hashSet = new HashSet<String>(listToAdd);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(listToAdd);
        TreeSet<String> treeSet = new TreeSet<String>(listToAdd);
        // TODO Exercise #3 c) Check the content of the Sets

        System.out.println("\nThe elements contained in the first Set: " + hashSet.toString());
        System.out.println("\nThe elements contained in the second Set: " + linkedHashSet.toString());
        System.out.println("\nThe elements contained in the third Set: " + treeSet.toString());
        treeSet.add("collection");
        treeSet.add("that");
        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: " + treeSet.toString());

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
    }
}

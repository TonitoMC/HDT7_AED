package uvg.edu.gt;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest extends TestCase {

    public void testAdd() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> expectedList = Arrays.asList(2,3,4,5,7);
        List<Integer> secondExpectedList = Arrays.asList(2,3,4,5,6,7);
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        assertEquals(bst.getOrderedList(), expectedList);
        bst.add(6);
        assertEquals(bst.getOrderedList(), secondExpectedList);
    }

}
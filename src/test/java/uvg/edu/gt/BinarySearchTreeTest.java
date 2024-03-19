package uvg.edu.gt;

import jdk.nashorn.internal.ir.Assignment;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest extends TestCase {

    public void testAdd() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        ArrayList<Association<Integer, String>> expectedList = new ArrayList<>();
        bst.add(1, "a");
        bst.add(8, "h");
        bst.add(3, "c");
        bst.add(5, "e");
        expectedList.add(new Association<>(1, "a"));
        expectedList.add(new Association<>(3, "c"));
        expectedList.add(new Association<>(5, "e"));
        expectedList.add(new Association<>(8, "h"));
        for (int i = 0; i < expectedList.size(); i++){
            assertEquals(expectedList.get(i).getKey(), bst.getOrderedList().get(i).getKey());
            assertEquals(expectedList.get(i).getValue(), bst.getOrderedList().get(i).getValue());
        }
    }
    public void testGetValueByKey(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.add(1, "a");
        bst.add(8, "h");
        bst.add(3, "c");
        bst.add(5, "e");
        assertEquals("a", bst.getValueByKey(1));
        assertEquals("c", bst.getValueByKey(3));
        assertEquals("e", bst.getValueByKey(5));
        assertEquals("h", bst.getValueByKey(8));
    }
}
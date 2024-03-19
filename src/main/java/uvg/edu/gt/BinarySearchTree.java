package uvg.edu.gt;

import java.util.ArrayList;

//https://stackoverflow.com/questions/11263244/java-how-do-i-implement-a-generic-binary-search-tree
public class BinarySearchTree<T extends Comparable<T>>{
    private class Node<E extends Comparable<E>>{
        E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E data){
            this.data = data;
        }
    }
    private Node<T> root;

    public T getRoot(){
        return this.root.data;
    }

    public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if (root == null){
            root = newNode;
        } else {
            Node<T> tempNode = root;
            Node<T> prev = null;
            while (tempNode != null){
                prev = tempNode;
                if (data.compareTo((tempNode.data)) > 0){
                    tempNode = tempNode.right;
                }  else {
                    tempNode = tempNode.left;
                }
            }
            if (data.compareTo(prev.data) < 0){
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
    }
    public ArrayList<T> getOrderedList(){
        ArrayList<T> orderedList = new ArrayList<>();
        transverseInOrder(this.root, orderedList);
        return orderedList;
    }
    private void transverseInOrder(Node<T> root, ArrayList<T> storageList){
        if (root != null){
            transverseInOrder(root.left, storageList);
            storageList.add(root.data);
            transverseInOrder(root.right,storageList);
        }
    }
}
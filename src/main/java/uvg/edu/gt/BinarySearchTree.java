package uvg.edu.gt;

import java.util.ArrayList;

//https://stackoverflow.com/questions/11263244/java-how-do-i-implement-a-generic-binary-search-tree
public class BinarySearchTree<K extends Comparable<K>, V> {
    private class Node {
        Association<K, V> data;
        public Node left;
        public Node right;

        public Node(Association<K, V> data) {
            this.data = data;
        }
    }

    private Node root;

    public void add(K key, V value) {
        Association<K, V> newData = new Association<>(key, value);
        Node newNode = new Node(newData);
        if (root == null) {
            root = newNode;
        } else {
            Node tempNode = root;
            Node prev = null;
            while (tempNode != null) {
                prev = tempNode;
                int cmp = newData.compareTo(tempNode.data);
                if (cmp > 0) {
                    tempNode = tempNode.right;
                } else if (cmp < 0) {
                    tempNode = tempNode.left;
                } else {
                    // Handle case where key already exists (if needed)
                    // For example, you might want to update the value in this case
                    tempNode.data.setValue(value);
                    return; // Exit the method after handling the case
                }
            }
            int cmp = newData.compareTo(prev.data);
            if (cmp < 0) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
    }

    public ArrayList<Association<K, V>> getOrderedList() {
        ArrayList<Association<K, V>> orderedList = new ArrayList<>();
        transverseInOrder(this.root, orderedList);
        return orderedList;
    }

    public V getValueByKey(K key) {
        Node node = findNode(root, key);
        return (node != null) ? node.data.getValue() : null;
    }

    private Node findNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.data.getKey());
        if (cmp < 0) {
            return findNode(node.left, key);
        } else if (cmp > 0) {
            return findNode(node.right, key);
        } else {
            return node;
        }
    }

    private void transverseInOrder(Node root, ArrayList<Association<K, V>> storageList) {
        if (root != null) {
            transverseInOrder(root.left, storageList);
            storageList.add(root.data);
            transverseInOrder(root.right, storageList);
        }
    }
}
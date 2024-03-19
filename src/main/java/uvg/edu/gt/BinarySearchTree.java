package uvg.edu.gt;

import java.util.ArrayList;

/**
 * Esta implementacion de Binary Search Tree se utiliza para almacenar pares de valores utilizando
 * Associations, se puede crear un tree con genericos (K y V, mientras K sea un Comparable). En el caso de este
 * programa se utiliza para almacenar palabras en ingles y su traduccion al espanol
 * @param <K> el tipo de dato que utiliza K, el Key de cada Association
 * @param <V> el tipo de dato que utiliza V, el Value de cada Association
 * @author Jose Merida
 * @version 1.0
 * @since 18-03-2024
 */

/**
 * Referencia BST https://stackoverflow.com/questions/11263244/java-how-do-i-implement-a-generic-binary-search-tree
 * realice modificaciones a la implementacion para que funcionara de manera mas adecuada con el programa
 */
public class BinarySearchTree<K extends Comparable<K>, V> {
    /**
     * La clase nodo se utiliza para almacenar datos en el BST, toma como 'data' un Association
     */
    private class Node {
        Association<K, V> data;
        public Node left;
        public Node right;

        public Node(Association<K, V> data) {
            this.data = data;
        }
    }
    private Node root;
    /**
     * Agrega un nuevo nodo, colocandolo en el lugar correcto basado en el parametro Key
     * @param key el Key del Association
     * @param value el Value del Association
     */
    public void add(K key, V value) {
        //Crea un nuevo association para poder compararlo con los ya existentes
        Association<K, V> newData = new Association<>(key, value);
        //Crea un nuevo nodo con el association creado anteriormente
        Node newNode = new Node(newData);
        //Si no existe el root, agrega el nuevo nodo como root
        if (root == null) {
            root = newNode;
        } else {
            //Recorre la lista comparando el nodo root, dependiendo de la comparacion se mueve hacia la izquierda
            //o derecha, seteando un nuevo nodo root.
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
                    tempNode.data.setValue(value);
                    return;
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
    /**
     * Retorna un ArrayList de la 'data' de cada nodo, recorriendo el arbol InOrder
     * @return un ArrayList con las asociaciones en orden
     */
    public ArrayList<Association<K, V>> getOrderedList() {
        ArrayList<Association<K, V>> orderedList = new ArrayList<>();
        transverseInOrder(this.root, orderedList);
        return orderedList;
    }
    /**
     * Obtiene el valor almacenado en el Association de un nodo basado en el key
     * @param key el key del Association que se desea buscar
     * @return el valor V del nodo, retorna null si no se encuentra el valor dentro del arbol
     */
    public V getValueByKey(K key) {
        Node node = findNode(root, key);
        return (node != null) ? node.data.getValue() : null;
    }
    /**
     * Este metodo funciona de manera recursiva para encontrar un nodo basado en el Key del Association, si es
     * menor al nodo root busca por la izquierda y se llama a si mismo nuevamente, si es mayor hace lo mismo pero hacia
     * la derecha
     * @param node el nodo con el que se compara
     * @param key la llave que se desea encontrar
     * @return el nodo en el que se encuentra la llave
     */
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
    /**
     * Recorre el arbol binario en orden, funciona de manera recursiva
     * @param root el nodo sobre el que se compara
     * @param storageList la lista en la que se almacenan los Associations
     */
    private void transverseInOrder(Node root, ArrayList<Association<K, V>> storageList) {
        if (root != null) {
            transverseInOrder(root.left, storageList);
            storageList.add(root.data);
            transverseInOrder(root.right, storageList);
        }
    }
}
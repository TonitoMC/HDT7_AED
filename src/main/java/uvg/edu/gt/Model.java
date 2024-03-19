package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
    private BinarySearchTree<String, String> binarySearchTree;
    private ArrayList<Association<String, String>> dictionaryList;
    public Model(){
        binarySearchTree = new BinarySearchTree<>();
        //readFile agrega los elementos al BST
        this.readFile();
        //updateList recorre el BST "In-Order" y agrega los elementos a dictionaryList.
        dictionaryList = binarySearchTree.getOrderedList();
    }
    private void readFile(){
        ArrayList<String> tempList = new ArrayList<String>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            while ((line = br.readLine()) != null) {
                tempList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String currentString : tempList){
            String updatedString = currentString.replaceAll("[( )]", "");
            String[] separated = updatedString.split(",");
            binarySearchTree.add(separated[0], separated[1]);
        }
    }
    public ArrayList<Association<String, String>> getDictionaryList(){
        return dictionaryList;
    }


}
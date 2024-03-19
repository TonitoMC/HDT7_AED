package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    private BinarySearchTree<String, String> binarySearchTree;
    private ArrayList<Association<String, String>> dictionaryList;
    private ArrayList<String> textFileList;
    public Model(){
        binarySearchTree = new BinarySearchTree<>();
        textFileList = new ArrayList<>();
        //readFile agrega los elementos al BST
        this.readDict();
        //updateList recorre el BST "In-Order" y agrega los elementos a dictionaryList.
        dictionaryList = binarySearchTree.getOrderedList();
        this.readText();
    }
    private void readDict(){
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
    public ArrayList<String> translate(){
        ArrayList<String> tempList = new ArrayList<String>();
        for (String p : textFileList){
            if (binarySearchTree.getValueByKey(p) != null){
                tempList.add(binarySearchTree.getValueByKey(p));
            } else {
                tempList.add("*" + p + "*");
            }
        }
        return tempList;
    }
    private void readText(){
        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                textFileList.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Association<String, String>> getDictionaryList(){
        return dictionaryList;
    }
    }

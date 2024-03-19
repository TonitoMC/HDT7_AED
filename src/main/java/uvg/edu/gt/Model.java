package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta clase se encarga del funcionamiento interno del programa. Lee los archivos de texto, almacena la informacion
 * dentro de un BST y dos ArrayLists.
 * @author Jose Merida
 * @version 1.0
 * @since 18-03-2024
 */
public class Model {
    private BinarySearchTree<String, String> binarySearchTree;
    private ArrayList<Association<String, String>> dictionaryList;
    private ArrayList<String> textFileList;
    /**
     * Crea un nuevo model
     */
    public Model(){
        //Crea el BST y los ArrayList para almacenar la informacion
        binarySearchTree = new BinarySearchTree<>();
        textFileList = new ArrayList<>();
        //readFile agrega los elementos al BST
        this.readDict();
        //updateList recorre el BST "In-Order" y agrega los elementos a dictionaryList.
        dictionaryList = binarySearchTree.getOrderedList();
        this.readText();
    }
    /**
     * Este metodo se encarga de leer el archivo de diccionario y almacenar los valores dentro del BST
     */
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
            binarySearchTree.add(separated[0].toLowerCase(), separated[1].toLowerCase());
        }
    }
    /**
     * Este metodo se encarga de traducir el texto, llama la funcion de busqueda por Key del BST y por cada
     * valor retorna su traduccion o la palabra original dentro de **.
     * @return
     */
    public ArrayList<String> translate(){
        ArrayList<String> tempList = new ArrayList<String>();
        for (String p : textFileList){
            p = p.toLowerCase();
            if (binarySearchTree.getValueByKey(p) != null){
                tempList.add(binarySearchTree.getValueByKey(p));
            } else {
                tempList.add("*" + p + "*");
            }
        }
        return tempList;
    }
    /**
     * Este metodo se encarga de leer el archivo de texto y almacena las palabras separadas por espacios vacios.
     */
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
    /**
     * Regresa la lista ordenada del diccionario
     * @return la lista
     */
    public ArrayList<Association<String, String>> getDictionaryList(){
        return dictionaryList;
    }
    }

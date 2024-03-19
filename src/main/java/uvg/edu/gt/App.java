package uvg.edu.gt;

import java.util.Scanner;

/**
 * Este programa funciona como un traductor de ingles - espanol, lee las traducciones literales (asociaciones) de
 * palabras en ingles y las almacena en un binary search tree. Este esta ordenado por el orden de las palabras en
 * ingles, donde cada nodo del BST tiene Associations que almacenan una llave y un valor. La llave son las
 * palabras en ingles y el valor las palabras en espanol.
 * @author Jose Merida
 * @version 1.0
 * @since 18-03-2024
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Model model = new Model();
        while(true){
            System.out.println("Bienvenido al programa de traduccion, ingrese el numero correspondiente a la ocpion:");
            System.out.println("1. Imprimir el diccionario, recorriendo el diccionario in order");
            System.out.println("2. Traducir el archivo proporcionado");
            int mainSelect = scanner.nextInt();
            switch (mainSelect){
                case 1:
                    for (Association<String, String> currentAssociation: model.getDictionaryList()){
                        System.out.println("(" + currentAssociation.getKey() + "," + currentAssociation.getValue() + ")");
                    }
                    break;
                case 2:
                    for (String p : model.translate()){
                        System.out.print(p + " ");
                    }
                    System.out.println(" ");
                    break;
            }
        }
    }
}

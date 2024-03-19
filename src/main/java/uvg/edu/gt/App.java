package uvg.edu.gt;

import java.util.Scanner;

/**
 * Hello world!
 *
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
            System.out.println("2. Traducir una frase de ingles a español");
            int mainSelect = scanner.nextInt();
            switch (mainSelect){
                case 1:
                    for (Association<String, String> currentAssociation: model.getDictionaryList()){
                        System.out.println("(" + currentAssociation.getKey() + "," + currentAssociation.getValue() + ")");
                    }
                    break;
                case 2:

            }
        }
    }
}

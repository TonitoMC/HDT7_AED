package uvg.edu.gt;

/**
 * Esta clase se utiliza para almacear Key-Value pairs dentro de un arbol de busqueda binario
 * @param <K> el tipo que utiliza el Key, debe ser Comparable
 * @param <V> el tipo que utiliza el Value
 */
public class Association<K extends Comparable<K>,V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;
    /**
     * Crea una nueva Association
     * @param key la llave
     * @param value el valor
     */
    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }
    /**
     * Compara asociaciones
     * @param input el Association con el que se desea comparar
     * @return int < 0 si es menor, 0 si es igual o mayor a 0 si es mayor
     */
    public int compareTo(Association<K, V> input){
        return (this.getKey().compareTo(input.getKey()));
    }
    /**
     * Getter para el key del Association
     * @return el key del Association
     */
    public K getKey(){
        return key;
    }
    /**
     * Getter para el value del Association
     * @return el value del association
     */
    public V getValue() {
        return value;
    }
    /**
     * Setter para el value del Association
     * @param value el valor que toma Value
     */
    public void setValue(V value) {
    }
}

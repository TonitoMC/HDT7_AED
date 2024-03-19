package uvg.edu.gt;

import java.util.Map;

public class Association<K extends Comparable<K>,V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;
    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }
    public int compareTo(Association<K, V> input){
        return (this.getKey().compareTo(input.getKey()));
    }
    public K getKey(){
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        return null;
    }

}

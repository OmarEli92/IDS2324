package it.unicam.cs.proxy;

import java.util.Collection;
import java.util.List;

public interface Cache<K,V> {

    /*** Restituisce una chiave di tipo K
     * @param key di tipo K
     * @return valore di tipo V**/
    V get(K key);
    /*** Inserisce un nuovo oggetto
     * @param key di tipo K
     * @param value di tipo V
     * @return key di tipo K**/
    K put(K key,V value);

    /*** Elimina un oggetto con chiave di tipo K
     * @param key di tipo K
     * **/
    void remove(K key);


    Collection<Node<V>> getAll();
}

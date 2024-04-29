package it.unicam.cs.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K,V> implements Cache<K,V>{
    private final int MAX_CAPACITY = 10;
    private int size;
    private final Map<K,Node<V>> map;
    private final DoubleLinkedList doubleLinkedList;


    public LRUCache(final int size) {
        this.size = size;
        this.doubleLinkedList = new DoubleLinkedList();
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public V get(K key) {
        Node node = map.get(key);
        if(node == null){
            throw new NullPointerException("L'elemento non è presente nella cache");
        }
        doubleLinkedList.moveNodeTohead(node);
        return (V) node.getValue();
    }

    @Override
    public K put(K key, V value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(value,null,null);
            doubleLinkedList.moveNodeTohead(node);
            map.put(key,node);
        }
        if(size == MAX_CAPACITY){
            Node temp = doubleLinkedList.getTail();
            Node prevTail = temp.getPrevious();
            prevTail.setNext(null);
            doubleLinkedList.setTail(prevTail);
        }
        else{
            node.setValue(value);
            doubleLinkedList.moveNodeTohead(node);
        }
        return null;
    }

    @Override
    public void remove(K key) {
        Node node = map.get(key);
        if(node == null){
            throw new NullPointerException("Non esiste nessun oggetto con tale chiave");
        }
        map.remove(key);
    }
}

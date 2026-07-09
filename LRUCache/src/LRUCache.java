import Entities.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public synchronized int get(int key){
        if(map.containsKey(key)){
            Node temp = map.get(key);
            removeNode(temp);
            addNode(temp);
            return temp.getValue();
        }
        return -1;
    }

    public synchronized void set(int key,int val){
        if (map.containsKey(key)){
            Node temp = map.get(key);
            temp.setValue(val);
            removeNode(temp);
            addNode(temp);
            return;
        }
        Node temp = new Node(key,val);
        map.put(key,temp);
        addNode(temp);
        if(map.size() > this.capacity){
            Node removeNode = head.getNext();
            removeNode(removeNode);
            map.remove(removeNode.getKey());
        }
    }

    private void removeNode(Node node){
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    private void addNode(Node node){
        Node temp = tail.getPrev();
        temp.setNext(node);
        node.setPrev(temp);
        node.setNext(tail);
        tail.setPrev(node);
    }

}

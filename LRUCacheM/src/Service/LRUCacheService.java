package Service;

import Model.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheService {

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCacheService(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public Integer get(int key) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            remove(target);
            add(target);
            return target.getValue();
        }
        return null;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node target = map.get(key);
            target.setValue(value);
            remove(target);
            add(target);
            return;
        }

        Node node = new Node(key,value);
        map.put(key,node);
        add(node);
        if(map.size() > capacity){
            Node lastElement = head.next;
            map.remove(lastElement.getKey());
            remove(lastElement);
        }

    }

    private void add(Node target) {
        Node lastNode = tail.prev;
        lastNode.next = target;
        target.prev = lastNode;
        target.next = tail;
        tail.prev = target;
    }

    private void remove(Node target) {
        target.next.prev = target.prev;
        target.prev.next = target.next;
    }


}

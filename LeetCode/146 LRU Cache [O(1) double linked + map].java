/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 /* capacity */ );
/**
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

class LRUCache {

    private Node head;
    private Node tail;
    private int count = 0;
    private int capacity = 0;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(mapContains(key)){
            Node node = map.get(key);
            updateUsing(node);
            return node.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if(mapContains(key)){
            Node node = map.get(key);
            node.value = value;
            updateUsing(node);
        }else{
            if(count < capacity){
                count++;
            }else{
                Node old = head.next;
                remove(old);
                map.remove(old.key);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key,newNode);
            insert(newNode);
        }

    }

    private boolean mapContains(int key){
        return map.get(key) != null;
    }

    private void insert(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void updateUsing(Node node){
        remove(node);
        insert(node);
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
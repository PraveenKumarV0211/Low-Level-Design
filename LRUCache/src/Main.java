public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);
        cache.set(2, 20);
        System.out.println(cache.get(1)); // 10
        cache.set(3, 30);                 // evicts key 2
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
        cache.set(4, 40);                 // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40

        // update existing key
        cache.set(3, 300);
        System.out.println(cache.get(3)); // 300
    }
}
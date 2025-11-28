package arrays;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCache<K, V> {
     Map<K, CacheEntry<V>> map = new HashMap<>();

     public static void main(String[] args) throws InterruptedException {
          InMemoryCache<String, String> map = new InMemoryCache<>();
          map.put("USER", "RAGHU", 3000);
          System.out.println(map.get("USER"));
          Thread.sleep(3000);
          System.out.println(map.get("USER"));
     }

     public void put(K key, V value, long expiryTime) {
          map.put(key, new CacheEntry<>(value, System.currentTimeMillis() + expiryTime));
     }

     public V get(K key) {
          CacheEntry<V> value = map.get(key);
          if (value == null) {
               return null;
          }
          if (System.currentTimeMillis() > value.expiry) {
               map.remove(key);
               return null;
          }
          return value.value;
     }

     private record CacheEntry<V>(V value, long expiry) {
     }
}

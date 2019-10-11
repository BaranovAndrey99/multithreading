package multithreading.concurrencyTools.collections.maps.concurrentHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        MapTask HashMapTask = new MapTask(hashMap);
        MapTask ConcurrentTask = new MapTask(concurrentHashMap);

        Thread ususal = new Thread(HashMapTask, "HashMapThread");
        Thread concurrent = new Thread(ConcurrentTask, "ConcurrentHashMapThread");

        System.out.println("        HashMap: ");
        ususal.start();
        ususal.join();

        System.out.println("\n***********************************");

        System.out.println("        ConcurrentHashMap: ");
        concurrent.start();
        concurrent.join();
    }
}

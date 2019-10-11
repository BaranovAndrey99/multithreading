package multithreading.concurrencyTools.collections.maps.concurrentHashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTask implements Runnable{
    private Map<String, String> map;

    public MapTask(Map<String, String> map) {
        this.map = map;
    }

    private void createMap() {
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }

    @Override
    public void run() {
        createMap();

        System.out.println("Before iterator : " + map);

        Iterator<String> iterator = map.keySet().iterator();

        System.out.print("Cycle : ");

        while (iterator.hasNext()) {
            String key = iterator.next();
            if(key.equals("2")) {
                map.put(key + "newValue", "222");
            } else {
                System.out.print("  " + key + "=" + map.get(key));
            }
        }
    }
}

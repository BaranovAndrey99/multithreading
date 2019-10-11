package multithreading.concurrencyTools.collections.copyOnWrite.copyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
    private List<String> list = new ArrayList<>();
    //private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public Example() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }

    public synchronized void printCollection(boolean doChanges) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if(doChanges) {
                list.remove(element);
                list.add("*");
            }
        }
    }
}

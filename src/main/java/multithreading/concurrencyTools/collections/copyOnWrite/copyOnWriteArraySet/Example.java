package multithreading.concurrencyTools.collections.copyOnWrite.copyOnWriteArraySet;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Example {
    private CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

    public Example() {
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
    }

    public synchronized void printCollection(boolean doChanges) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if(doChanges) {
                set.remove(element);
                set.add("*");
            }
        }
    }
}

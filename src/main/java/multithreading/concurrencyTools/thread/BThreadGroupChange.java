package multithreading.concurrencyTools.thread;

public class BThreadGroupChange {
    public static void main(String[] args) {
        /*
         * Change thread group.
         */
        ThreadGroup threadGroup = new ThreadGroup( "OurGroup");
        threadGroup.setMaxPriority(1);

        Thread thread = new Thread(threadGroup, "ThreadInOurGroup");

        System.out.println("Thread group: " + thread.getThreadGroup());
        System.out.println("Thread priority " + thread.getPriority());

        thread.start();
    }
}

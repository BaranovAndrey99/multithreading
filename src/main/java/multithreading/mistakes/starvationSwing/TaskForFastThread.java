package multithreading.mistakes.starvationSwing;

public class TaskForFastThread implements Runnable {
    private JPanelProgressBar component;
    private final Object sharedObject;

    public TaskForFastThread(JPanelProgressBar component, Object sharedObject) {
        this.component = component;
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        int barValue = 0;
        while (true) {
            synchronized (sharedObject) {
                if (barValue == 100) {
                    barValue = 0;
                }
                this.component.jProgressBar.setValue(barValue++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package multithreading.mistakes.starvationSwing;

public class TaskForSlowThread implements Runnable{
    private JPanelProgressBar component;
    private final Object sharedObject;

    public TaskForSlowThread(JPanelProgressBar component, Object sharedObject) {
        this.component = component;
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        int barValue = 0;
        while (true) {
            synchronized (sharedObject) {
                try {
                    for(int i = 0; i < 2; i++) {
                        if (barValue == 100) {
                            barValue = 0;
                        }
                        this.component.jProgressBar.setValue(barValue++);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

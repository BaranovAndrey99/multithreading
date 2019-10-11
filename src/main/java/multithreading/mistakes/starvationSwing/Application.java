package multithreading.mistakes.starvationSwing;

import javax.swing.*;
import java.awt.*;

public class Application {
    private static Object sharedObject = new Object();

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Starvation");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(300, 300));
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        for(int i = 0; i < 2; i++) {
            JPanelProgressBar progressBar = new JPanelProgressBar();
            jFrame.add(progressBar.getProgressComponent());

            //Runnable taskForThread;

            if(i == 0) {
                TaskForSlowThread taskForSlowThread = new TaskForSlowThread(progressBar, sharedObject);
                Thread thread = new Thread(taskForSlowThread, "Slow");
                thread.start();
            } else {
                TaskForFastThread taskForFastThread = new TaskForFastThread(progressBar, sharedObject);
                Thread thread = new Thread(taskForFastThread, "Fast" + i);
                thread.start();
            }

            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }
}

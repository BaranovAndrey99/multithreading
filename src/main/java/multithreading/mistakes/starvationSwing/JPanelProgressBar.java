package multithreading.mistakes.starvationSwing;

import javax.swing.*;

public class JPanelProgressBar {
    JProgressBar jProgressBar;

    public JPanelProgressBar() {
        this.jProgressBar = new JProgressBar();
        this.jProgressBar.setStringPainted(true);
        this.jProgressBar.setMaximum(100);
    }

    JComponent getProgressComponent () {
        return jProgressBar;
    }
}

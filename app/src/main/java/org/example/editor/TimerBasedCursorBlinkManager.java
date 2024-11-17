package org.example.editor;

import javax.swing.*;
import java.awt.*;

public class TimerBasedCursorBlinkManager implements CursorBlinkManager {
    public static final int BLINK_INTERVAL = 500;
    private boolean isVisible;


    public TimerBasedCursorBlinkManager(Component component) {
        this.isVisible = true;

        Timer timer = new Timer(BLINK_INTERVAL, e -> {
           isVisible = !isVisible;
           component.repaint();
        });
        timer.start();
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }
}

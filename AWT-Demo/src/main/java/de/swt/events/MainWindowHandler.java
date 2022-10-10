package de.swt.events;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        e.getWindow().dispose();
        System.exit(0);
    }


}

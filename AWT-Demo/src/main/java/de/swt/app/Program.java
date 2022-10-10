package de.swt.app;

import de.swt.events.MainWindowHandler;
import de.swt.ui.DrawingCanvas;
import de.swt.ui.MainWindow;

/**
 * AWT-DEMO 2022
 *
 * @author Nico Scheithauer
 * <p>
 * Das Projekt AWT-Demo dient als Schablone für eigene AWT-Programme
 */
public class Program {

    public static MainWindow mainWindow;

    public static void main(String[] args) {
        mainWindow.setLocationRelativeTo(null);
        mainWindow = new MainWindow();
        mainWindow.setHandler(new MainWindowHandler());
        mainWindow.add(new DrawingCanvas());
        mainWindow.showFrame();
    }

}

package de.swt.app;

import de.swt.events.MainWindowHandler;
import de.swt.ui.BackgroundMenu;
import de.swt.ui.DrawingCanvas;
import de.swt.ui.MainWindow;

/**
 * AWT-DEMO 2022
 *
 * @author Nico Scheithauer <br>
 *
 * Das Projekt AWT-Demo dient als Schablone für eigene AWT-Programme
 */
public class Program {

    public static MainWindow mainWindow = new MainWindow();

    public static void main(String[] args) {
        BackgroundMenu menu = new BackgroundMenu();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setMenuBar(menu.menuBar());
        mainWindow.setHandler(new MainWindowHandler());
        mainWindow.add(new DrawingCanvas());
        mainWindow.showFrame();
    }

}

package de.swt.app;

import de.swt.events.MainWindowHandler;
import de.swt.ui.MainWindow;

/**
 * AWT-DEMO 2022
 * @Author: Nico Scheithauer
 *
 * Das Projekt AWT-Demo dient als Schablone für eigene AWT-Programme
 */
public class Program {

    private static MainWindow mainWindow;
    private static MainWindowHandler mainWindowHandler;

    public static void main(String[] args){
            mainWindowHandler = new MainWindowHandler();

            mainWindow = new MainWindow();
            mainWindow.setHandler(mainWindowHandler);
            mainWindow.showFrame();
    }

}

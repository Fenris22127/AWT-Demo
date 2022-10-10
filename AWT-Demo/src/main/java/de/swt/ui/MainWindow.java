package de.swt.ui;

import de.swt.events.MainWindowHandler;

import java.awt.*;


public class MainWindow extends Frame {

        public MainWindow(){
            setSize(500,300);
            setTitle("AWT DEMO");
        }


        public void showFrame(){
            this.setVisible(true);
        }

        public void setHandler(MainWindowHandler mainWindowHandler) {
            addWindowListener(mainWindowHandler);
         }
}

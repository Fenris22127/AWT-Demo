package de.swt.ui;

import javax.swing.*;
import java.awt.*;

import static de.swt.app.Program.mainWindow;

public class BackgroundMenu extends Component {
    public static Color backgroundColor = Color.GRAY;
    public static Menu coords = new Menu("");

    public MenuBar menuBar() {
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Background");


        menu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        MenuItem i1 = new MenuItem("Grey");
        i1.addActionListener(e -> {
            mainWindow.getComponent(0).setBackground(Color.GRAY);
            backgroundColor = Color.GRAY;
        });
        MenuItem i2 = new MenuItem("White");
        i2.addActionListener(e -> {
            mainWindow.getComponent(0).setBackground(Color.WHITE);
            backgroundColor = Color.WHITE;
        });
        MenuItem i3 = new MenuItem("Black");
        i3.addActionListener(e -> {
            mainWindow.getComponent(0).setBackground(Color.BLACK);
            backgroundColor = Color.BLACK;
        });
        MenuItem i4 = new MenuItem("Custom");
        i4.addActionListener(e -> chooseColor());
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        mb.add(menu);
        mb.add(coords);

        return mb;
    }

    private static void chooseColor() {
        Color c = JColorChooser.showDialog(new BackgroundMenu(), "Choose", Color.WHITE);
        mainWindow.getComponent(0).setBackground(c);
        backgroundColor = c;
    }

    public static Color getBackgroundColor() {
        return backgroundColor;
    }
}


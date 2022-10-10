package de.swt.ui;

import de.swt.events.MouseClick;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static de.swt.app.Program.mainWindow;

public class DrawingCanvas extends Canvas {
    MouseClick ma = new MouseClick(this);
    public int count = 0;

    public DrawingCanvas() {
        setSize(500, 500);
        addMouseListener(ma);
        setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse2D;
        ellipse2D = new Ellipse2D.Float(
                ma.x, ma.y,
                5.0F, 5.0F);
        g2d.draw(ellipse2D);
    }

    public boolean clear() {
        mainWindow.remove(0);
        mainWindow.add(new DrawingCanvas());
        return mainWindow.getComponent(0).getClass() == DrawingCanvas.class;
    }

}
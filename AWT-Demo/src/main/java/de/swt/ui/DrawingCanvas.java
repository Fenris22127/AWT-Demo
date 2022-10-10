package de.swt.ui;

import de.swt.events.MouseClick;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawingCanvas extends Canvas {
    MouseClick ma = new MouseClick(this);
    public int count = -1;

    public DrawingCanvas() {
        setSize(500, 500);
        addMouseListener(ma);
        setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (count != -1) {

            Ellipse2D ellipse2D;
            ellipse2D = new Ellipse2D.Float(
                    ma.x, ma.y,
                    5.0F, 5.0F);
            g2d.draw(ellipse2D);
            String s = "Circle " + count + ": x: " + ma.x + " y: " + ma.y;
            g2d.drawString(s, 360, 20 * count);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void clear(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0,
                this.getWidth(), this.getHeight());
    }

}

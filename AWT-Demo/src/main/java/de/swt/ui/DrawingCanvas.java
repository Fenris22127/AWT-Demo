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
        if (!ma.circles.isEmpty()) {
            for (int i = 0; i < ma.circles.size(); i++) {
                g2d.draw(new Ellipse2D.Float(
                        ma.circles.get(i).coordsX,
                        ma.circles.get(i).coordsY,
                        ma.circles.get(i).radius,
                        ma.circles.get(i).radius));
            }
        }
    }

    public void clear(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0,
                this.getWidth(), this.getHeight());
    }

}

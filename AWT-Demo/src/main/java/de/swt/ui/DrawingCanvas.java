package de.swt.ui;

import de.swt.events.MouseClick;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static de.swt.ui.BackgroundMenu.getBackgroundColor;

public class DrawingCanvas extends Canvas {
    public static float circleRadius = 5.0F;
    MouseClick ma = new MouseClick(this);
    public int count = 0;

    public DrawingCanvas() {
        setSize(500, 500);
        addMouseListener(ma);
        setBackground(getBackgroundColor());
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
                String s = "Circle " + (i + 1) + ": x: " + ma.circles.get(i).coordsX + " y: " + ma.circles.get(i).coordsY;
                g2d.drawString(s, 360, 20 * (i + 1));

            }
            if (ma.circles.size() == 2) {
                double distance = Math.sqrt(
                        (ma.circles.get(1).coordsY - ma.circles.get(0).coordsY) *
                                (ma.circles.get(1).coordsY - ma.circles.get(0).coordsY) +
                                (ma.circles.get(1).coordsX - ma.circles.get(0).coordsX) *
                                        (ma.circles.get(1).coordsX - ma.circles.get(0).coordsX));
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                String s = "Distance: " + df.format(distance) + " px";
                g2d.drawString(s, 360, 60);
            }
        }
    }

    public void clear(Graphics2D g2d) {
        g2d.setColor(getBackgroundColor());
        g2d.fillRect(0, 0,
                this.getWidth(), this.getHeight());
    }

    public static void setCircleRadius(float radius) {
        circleRadius = radius;
    }
}

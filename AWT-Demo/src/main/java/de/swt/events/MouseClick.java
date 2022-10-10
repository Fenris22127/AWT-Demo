package de.swt.events;

import de.swt.ui.DrawingCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements ActionListener, MouseListener {
    public int x;
    public int y;
    public DrawingCanvas draw;
    String s = "";
    public MouseClick(DrawingCanvas draw) {
        this.draw = draw;
    }

    public void mouseClicked(MouseEvent e) {
        Graphics g = draw.getGraphics();
        if (draw.count == 2) {
            draw.clear((Graphics2D) g);
            draw.count = 0;
        } else {
            if (draw.count == -1) draw.count = 0;
            draw.count++;
            x = e.getX();
            y = e.getY();
            draw.repaint();
        }
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

    }
}

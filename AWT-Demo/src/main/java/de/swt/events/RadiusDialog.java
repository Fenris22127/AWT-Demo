package de.swt.events;

import de.swt.ui.DrawingCanvas;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static de.swt.app.Program.mainWindow;
import static de.swt.ui.BackgroundMenu.getBackgroundColor;
import static de.swt.ui.DrawingCanvas.setCircleRadius;

public class RadiusDialog extends Dialog {
    protected TextField textField;

    public RadiusDialog(Frame parent) {
        super(parent, true);
        Dimension parentDim = parent.getSize();

        //setLocationRelativeTo(null);
        setBackground(getBackgroundColor());
        setLayout(new BorderLayout());

        Label l = new Label("Set Radius");
        l.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l, BorderLayout.PAGE_START);

        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());
        Button setRadius = new Button("Set");
        setRadius.addActionListener(e -> {
            String text = textField.getText();
            try {
                setCircleRadius(Float.parseFloat(text));
                dispose();
            } catch (NumberFormatException nfe) {
                Component c = mainWindow.getComponent(0);
                if (c.getClass() == DrawingCanvas.class) {
                    String errorText = "Not a valid radius!";
                    Graphics2D g2d = (Graphics2D) c.getGraphics();
                    g2d.setColor(Color.red);
                    g2d.setFont(new Font("Tahoma", Font.BOLD, 14));
                    int width = g2d.getFontMetrics().stringWidth(errorText);
                    int textX = (c.getWidth() - width) / 2;
                    g2d.drawString(errorText, textX, 20);
                }

            }
        });
        panel.add(setRadius);
        Button cancel = new Button("Cancel");
        cancel.addActionListener(e -> dispose());
        panel.add(cancel);
        add(panel, BorderLayout.PAGE_END);

        textField = new TextField(1);
        textField.setPreferredSize(new Dimension(100, 50));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));

        panel = new Panel();
        panel.add(textField);
        add(panel, BorderLayout.CENTER);
        setSize(200, 200);
        Dimension dialogDim = this.getSize();
        setLocation(parent.getX() + ((parentDim.width / 2) - (dialogDim.width / 2)), parent.getY() + ((parentDim.height / 2) - (dialogDim.height / 2)));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
            }
        });
    }
}

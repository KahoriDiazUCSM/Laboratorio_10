package actividad1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GraficosAvanzadosPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rectángulo girado
        AffineTransform original = g2d.getTransform();
        g2d.rotate(Math.toRadians(45), 100, 100);
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(50, 50, 100, 50);
        g2d.setTransform(original);
    }
}

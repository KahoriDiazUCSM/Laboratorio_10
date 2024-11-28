package actividad1;

import javax.swing.*;
import java.awt.*;

class GraficosSimplesPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawRect(50, 50, 100, 50); // Rectángulo
        g.setColor(Color.RED);
        g.fillOval(200, 50, 50, 50); // Círculo lleno
        g.setColor(Color.BLACK);
        g.drawString("Gráficos Simples", 50, 150); // Texto
    }
}

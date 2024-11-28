package actividad1;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame menuFrame = new JFrame("Aplicación Educativa");
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menuFrame.setSize(300, 200);
            menuFrame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

            JButton bindingButton = new JButton("Gestión de Datos");
            bindingButton.addActionListener(e -> new VentanaBinding());

            JButton graficosSimplesButton = new JButton("Gráficos Simples");
            graficosSimplesButton.addActionListener(e -> new VentanaGraficosSimples());

            JButton graficosAvanzadosButton = new JButton("Gráficos Avanzados");
            graficosAvanzadosButton.addActionListener(e -> new VentanaGraficosAvanzados());

            JButton multimediaButton = new JButton("Multimedia");
            multimediaButton.addActionListener(e -> new VentanaMultimedia());

            panel.add(bindingButton);
            panel.add(graficosSimplesButton);
            panel.add(graficosAvanzadosButton);
            panel.add(multimediaButton);

            menuFrame.add(panel);
            menuFrame.setVisible(true);
        });
    }
}

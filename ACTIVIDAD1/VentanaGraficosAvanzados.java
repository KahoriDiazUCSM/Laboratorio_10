package actividad1;

import javax.swing.*;

public class VentanaGraficosAvanzados extends JFrame {
    public VentanaGraficosAvanzados() {
        setTitle("Gráficos Avanzados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        add(new GraficosAvanzadosPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaGraficosAvanzados::new);
    }
}

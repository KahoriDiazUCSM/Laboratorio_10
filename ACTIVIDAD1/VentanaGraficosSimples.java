package actividad1;
import javax.swing.*;



public class VentanaGraficosSimples extends JFrame {
    public VentanaGraficosSimples() {
        setTitle("Gráficos Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        add(new GraficosSimplesPanel());  // No pasa el parámetro aquí
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaGraficosSimples::new);  // Llama al constructor sin parámetros
    }
}


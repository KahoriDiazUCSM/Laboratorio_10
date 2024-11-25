import javax.swing.*;
import java.awt.*;

public class AppGraficoBarras extends JPanel {
    // Datos de ejemplo
    private String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"};
    private int[] ventas = {50, 120, 80, 150}; // Ventas en unidades

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Configuración de Graphics2D y activación de antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Configuración de dimensiones y colores del gráfico
        int anchoBarra = 50; // Ancho de cada barra
        int espacioBarra = 20; // Espacio entre barras
        int margenIzquierdo = 50; // Margen desde la izquierda
        int margenInferior = 50; // Margen desde la parte inferior
        int alturaMaxima = 200; // Altura máxima del gráfico

        // Encontrar el valor máximo de ventas para escalar las barras proporcionalmente
        int maxVenta = 0;
        for (int venta : ventas) {
            if (venta > maxVenta) {
                maxVenta = venta;
            }
        }

        // Dibujar las barras
        for (int i = 0; i < productos.length; i++) {
            // Calcular altura de la barra basada en las ventas
            int alturaBarra = (int) ((double) ventas[i] / maxVenta * alturaMaxima);

            // Coordenadas para la barra
            int x = margenIzquierdo + i * (anchoBarra + espacioBarra); // Posición en X
            int y = getHeight() - margenInferior - alturaBarra; // Posición en Y

            // Dibujar la barra
            g2d.setColor(new Color(100, 150, 200)); // Color azul para las barras
            g2d.fillRect(x, y, anchoBarra, alturaBarra);

            // Dibujar la etiqueta de ventas encima de cada barra
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(ventas[i]), x + (anchoBarra / 4), y - 5);

            // Dibujar el nombre del producto debajo de cada barra
            g2d.drawString(productos[i], x, getHeight() - margenInferior + 20);
        }

        // Dibujar el eje Y y su título
        g2d.setColor(Color.BLACK);
        g2d.drawLine(margenIzquierdo, getHeight() - margenInferior, margenIzquierdo, getHeight() - margenInferior - alturaMaxima);
        g2d.drawString("Ventas", margenIzquierdo - 40, getHeight() - margenInferior - alturaMaxima);
    }

    public static void main(String[] args) {
        // Crear un JFrame para mostrar el gráfico
        JFrame frame = new JFrame("Visualización de Datos - Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Agregar el panel con el gráfico de barras al frame
        AppGraficoBarras grafico = new AppGraficoBarras();
        frame.add(grafico);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

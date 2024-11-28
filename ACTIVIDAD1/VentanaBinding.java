package actividad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class VentanaBinding extends JFrame {
    public VentanaBinding() {
        setTitle("Binding de Datos Manual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Modelo
        Producto producto = new Producto("Producto A", 100.0, 10);

        // Componentes
        JTextField nombreField = new JTextField(producto.getNombre(), 15);
        JTextField precioField = new JTextField(String.valueOf(producto.getPrecio()), 15);
        JTextField stockField = new JTextField(String.valueOf(producto.getCantidadStock()), 15);
        JButton actualizarButton = new JButton("Actualizar Producto");

        // Panel y disposición
        setLayout(new GridLayout(5, 2));
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Precio:"));
        add(precioField);
        add(new JLabel("Stock:"));
        add(stockField);
        add(new JLabel());
        add(actualizarButton);

        // Acción al presionar el botón
        actualizarButton.addActionListener(e -> {
            try {
                producto.setNombre(nombreField.getText());
                producto.setPrecio(Double.parseDouble(precioField.getText()));
                producto.setCantidadStock(Integer.parseInt(stockField.getText()));
                JOptionPane.showMessageDialog(this, "Producto actualizado:\n" + producto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifique los campos.");
            }
        });

        setVisible(true);
    }
}


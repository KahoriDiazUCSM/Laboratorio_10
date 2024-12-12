package vista;

import modelo.Receta;
import modelo.RecetaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalleRecetaVista extends JFrame {
    private JButton botonGuardar;
    private RecetaModelo recetaModelo;

    public DetalleRecetaVista(Receta receta, int usuarioId, RecetaModelo recetaModelo) {
        this.recetaModelo = recetaModelo;
        setTitle(receta.getNombre());
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panelDetalles = new JPanel();
        panelDetalles.setLayout(new BoxLayout(panelDetalles, BoxLayout.Y_AXIS));
        panelDetalles.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelDetalles.setBackground(new Color(240, 240, 240));

        JLabel labelNombre = new JLabel("Nombre: " + receta.getNombre());
        labelNombre.setFont(new Font("Arial", Font.BOLD, 24));
        labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDetalles.add(labelNombre);
        panelDetalles.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel labelCategoria = new JLabel("Categoría: " + receta.getCategoria());
        labelCategoria.setFont(new Font("Arial", Font.PLAIN, 18));
        labelCategoria.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDetalles.add(labelCategoria);
        panelDetalles.add(Box.createRigidArea(new Dimension(0, 20)));

        // Nombre del creador de la receta
        String nombreCreador = recetaModelo.obtenerNombreUsuarioPorReceta(receta.getId());
        JLabel labelCreador = new JLabel("Creado por: " + nombreCreador);
        labelCreador.setFont(new Font("Arial", Font.PLAIN, 16));
        labelCreador.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDetalles.add(labelCreador);
        panelDetalles.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel ingredientesLabel = new JLabel("Ingredientes:");
        ingredientesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        ingredientesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelDetalles.add(ingredientesLabel);

        JTextArea areaIngredientes = new JTextArea(receta.getIngredientes());
        areaIngredientes.setFont(new Font("Arial", Font.PLAIN, 16));
        areaIngredientes.setEditable(false);
        areaIngredientes.setLineWrap(true);
        areaIngredientes.setWrapStyleWord(true);
        JScrollPane ingredientesScrollPane = new JScrollPane(areaIngredientes);
        ingredientesScrollPane.setPreferredSize(new Dimension(500, 100));
        panelDetalles.add(ingredientesScrollPane);
        panelDetalles.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel pasosLabel = new JLabel("Pasos:");
        pasosLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pasosLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelDetalles.add(pasosLabel);

        JTextArea areaPasos = new JTextArea(receta.getPasos());
        areaPasos.setFont(new Font("Arial", Font.PLAIN, 16));
        areaPasos.setEditable(false);
        areaPasos.setLineWrap(true);
        areaPasos.setWrapStyleWord(true);
        JScrollPane pasosScrollPane = new JScrollPane(areaPasos);
        pasosScrollPane.setPreferredSize(new Dimension(500, 150));
        panelDetalles.add(pasosScrollPane);
        panelDetalles.add(Box.createRigidArea(new Dimension(0, 20)));

        botonGuardar = new JButton("Guardar Receta");
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 18));
        botonGuardar.setBackground(new Color(76, 175, 80));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarReceta(receta.getId(), usuarioId);
            }
        });
        panelDetalles.add(botonGuardar);

        add(panelDetalles, BorderLayout.CENTER);

        setVisible(true);
    }

    private void guardarReceta(int recetaId, int usuarioId) {
        boolean guardado = recetaModelo.guardarReceta(recetaId, usuarioId);
        if (guardado) {
            JOptionPane.showMessageDialog(this, "Receta guardada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "La receta ya está guardada por el usuario.");
        }
    }
}

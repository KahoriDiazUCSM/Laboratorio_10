package vista;

import modelo.Receta;
import modelo.RecetaModelo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RecetasGuardadasVista extends JFrame {
    private int usuarioId;
    private RecetaModelo recetaModelo;

    public RecetasGuardadasVista(List<Receta> recetas, int usuarioId, RecetaModelo recetaModelo) {
        this.usuarioId = usuarioId;
        this.recetaModelo = recetaModelo;

        setTitle("Recetas Guardadas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 240, 240));

        JLabel tituloLabel = new JLabel("Recetas Guardadas");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(tituloLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        if (recetas.isEmpty()) {
            JLabel mensajeLabel = new JLabel("No tienes recetas guardadas.");
            mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelPrincipal.add(mensajeLabel);
        } else {
            for (Receta receta : recetas) {
                JButton botonReceta = new JButton(receta.getNombre());
                botonReceta.setFont(new Font("Arial", Font.BOLD, 18));
                botonReceta.setBackground(new Color(33, 150, 243));
                botonReceta.setForeground(Color.WHITE);
                botonReceta.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                botonReceta.addActionListener(e -> new DetalleRecetaVista(receta, usuarioId, recetaModelo));
                panelPrincipal.add(botonReceta);
                panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        add(new JScrollPane(panelPrincipal), BorderLayout.CENTER);

        setVisible(true);
    }
}

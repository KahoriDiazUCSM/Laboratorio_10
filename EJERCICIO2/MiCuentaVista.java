package vista;

import javax.swing.*;
import java.awt.*;

public class MiCuentaVista extends JFrame {
    private JButton botonAgregarReceta;
    private JButton botonRecetasCreadas;
    private JButton botonRecetasGuardadas;

    public MiCuentaVista(String nombreUsuario) {
        setTitle("Mi Cuenta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 240, 240));

        JLabel tituloAppLabel = new JLabel("PicaApp");
        tituloAppLabel.setFont(new Font("Arial", Font.BOLD, 32));
        tituloAppLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(tituloAppLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel nombreUsuarioLabel = new JLabel("Bienvenido, " + nombreUsuario);
        nombreUsuarioLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreUsuarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(nombreUsuarioLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 40)));

        botonAgregarReceta = new JButton("Agregar Receta");
        botonAgregarReceta.setFont(new Font("Arial", Font.BOLD, 18));
        botonAgregarReceta.setBackground(new Color(76, 175, 80));
        botonAgregarReceta.setForeground(Color.WHITE);
        botonAgregarReceta.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botonAgregarReceta.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(botonAgregarReceta);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        botonRecetasCreadas = new JButton("Ver Recetas Creadas");
        botonRecetasCreadas.setFont(new Font("Arial", Font.BOLD, 18));
        botonRecetasCreadas.setBackground(new Color(33, 150, 243));
        botonRecetasCreadas.setForeground(Color.WHITE);
        botonRecetasCreadas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botonRecetasCreadas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(botonRecetasCreadas);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        botonRecetasGuardadas = new JButton("Ver Recetas Guardadas");
        botonRecetasGuardadas.setFont(new Font("Arial", Font.BOLD, 18));
        botonRecetasGuardadas.setBackground(new Color(255, 152, 0));
        botonRecetasGuardadas.setForeground(Color.WHITE);
        botonRecetasGuardadas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botonRecetasGuardadas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(botonRecetasGuardadas);

        add(panelPrincipal, BorderLayout.CENTER);

        setVisible(true);
    }

    public JButton getBotonAgregarReceta() {
        return botonAgregarReceta;
    }

    public JButton getBotonRecetasCreadas() {
        return botonRecetasCreadas;
    }

    public JButton getBotonRecetasGuardadas() {
        return botonRecetasGuardadas;
    }
}

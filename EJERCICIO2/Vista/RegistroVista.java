package vista;

import javax.swing.*;
import java.awt.*;

public class RegistroVista extends JFrame {
    private JTextField nombreUsuarioField;
    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JPasswordField confirmarContrasenaField;
    private JButton registrarButton;
    private JButton volverButton;

    public RegistroVista() {
        setTitle("Registro en PicaApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());

        Color azul = new Color(39, 127, 255);
        Color grisClaro = new Color(245, 245, 245);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel textoPicaApp = new JLabel("PicaApp", SwingConstants.CENTER);
        textoPicaApp.setFont(new Font("Arial", Font.BOLD, 24));
        textoPicaApp.setForeground(azul);

        JLabel imagenLabel = new JLabel(new ImageIcon("D:\\JAVA-P\\PicaApp\\imagen1.jpg"));
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(textoPicaApp, BorderLayout.NORTH);
        headerPanel.add(imagenLabel, BorderLayout.CENTER);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        formPanel.setBackground(grisClaro);

        JLabel nombreUsuarioLabel = new JLabel("Nombre de usuario:");
        nombreUsuarioField = new JTextField(20);
        JLabel correoLabel = new JLabel("Correo electrónico:");
        correoField = new JTextField(20);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField(20);
        JLabel confirmarContrasenaLabel = new JLabel("Confirmar contraseña:");
        confirmarContrasenaField = new JPasswordField(20);

        registrarButton = crearBotonEstilizado("Registrar", azul, Color.WHITE);
        volverButton = crearBotonEstilizado("Volver", grisClaro, azul);

        formPanel.add(nombreUsuarioLabel);
        formPanel.add(nombreUsuarioField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(correoLabel);
        formPanel.add(correoField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(contrasenaLabel);
        formPanel.add(contrasenaField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(confirmarContrasenaLabel);
        formPanel.add(confirmarContrasenaField);
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(registrarButton);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(volverButton);

        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton crearBotonEstilizado(String texto, Color fondo, Color textoColor) {
        JButton boton = new JButton(texto);
        boton.setBackground(fondo);
        boton.setForeground(textoColor);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createLineBorder(fondo, 1, true));
        return boton;
    }

    public JTextField getNombreUsuarioField() {
        return nombreUsuarioField;
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    public JPasswordField getConfirmarContrasenaField() {
        return confirmarContrasenaField;
    }

    public JButton getRegistrarButton() {
        return registrarButton;
    }

    public JButton getVolverButton() {
        return volverButton;
    }
}

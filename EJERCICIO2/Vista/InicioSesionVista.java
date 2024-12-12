package vista;

import javax.swing.*;
import java.awt.*;

public class InicioSesionVista extends JFrame {
    private JTextField nombreUsuarioField;
    private JPasswordField contrasenaField;
    private JButton iniciarSesionButton;
    private JButton registroButton;
    private JButton recuperarContrasenaButton;

    public InicioSesionVista() {
        setTitle("Bienvenido a PicaApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        Color naranja = new Color(255, 127, 39);
        Color grisClaro = new Color(245, 245, 245);

        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(grisClaro);

        JLabel textoPicaApp = new JLabel("PicaApp", SwingConstants.CENTER);
        textoPicaApp.setFont(new Font("Arial", Font.BOLD, 24));
        textoPicaApp.setForeground(naranja);

        ImageIcon imagenIcon = new ImageIcon("D:\\JAVA-P\\PicaApp\\logo1.png");
        Image imagenRedimensionada = imagenIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imagenLabel = new JLabel(new ImageIcon(imagenRedimensionada));
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        logoPanel.add(textoPicaApp, BorderLayout.NORTH);
        logoPanel.add(imagenLabel, BorderLayout.CENTER);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        formPanel.setBackground(grisClaro);

        JLabel nombreUsuarioLabel = new JLabel("Nombre de usuario:");
        nombreUsuarioField = new JTextField(20);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField(20);

        iniciarSesionButton = crearBotonEstilizado("Iniciar Sesión", naranja, Color.WHITE);
        registroButton = crearBotonEstilizado("Registrarse", grisClaro, naranja);
        recuperarContrasenaButton = crearBotonEstilizado("Recuperar Contraseña", grisClaro, naranja);

        formPanel.add(nombreUsuarioLabel);
        formPanel.add(nombreUsuarioField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(contrasenaLabel);
        formPanel.add(contrasenaField);
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(iniciarSesionButton);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(registroButton);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(recuperarContrasenaButton);

        add(logoPanel, BorderLayout.NORTH);
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

    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public JButton getRegistroButton() {
        return registroButton;
    }

    public JButton getRecuperarContrasenaButton() {
        return recuperarContrasenaButton;
    }
}

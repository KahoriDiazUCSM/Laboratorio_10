package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecuperarContrasenaVista extends JFrame {

    private JTextField correoField;
    private JButton recuperarButton;

    public RecuperarContrasenaVista() {
        setTitle("PicaApp - Recuperar Contraseña");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE); 

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 
        panel.setBackground(Color.WHITE); 

        // Título
        JLabel titleLabel = new JLabel("Recuperar Contraseña");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.RED); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        JLabel logoLabel = new JLabel("🅿️");
        logoLabel.setFont(new Font("SansSerif", Font.PLAIN, 64));
        logoLabel.setForeground(new Color(255, 87, 51)); 
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel.add(logoLabel);

        //Etiqueta y campo para Correo
        JLabel correoLabel = new JLabel("Correo Electrónico");
        correoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        correoField = new JTextField(15);
        correoField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(correoLabel);
        panel.add(correoField);

        //botón para recuperar contraseña
        recuperarButton = new JButton("Recuperar Contraseña");
        recuperarButton.setBackground(new Color(255, 255, 153)); 
        recuperarButton.setForeground(Color.DARK_GRAY); 
        recuperarButton.setFocusPainted(false);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(recuperarButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public JButton getRecuperarButton() {
        return recuperarButton;
    }

    public void addRecuperarListener(ActionListener listener) {
        recuperarButton.addActionListener(listener);
    }
}

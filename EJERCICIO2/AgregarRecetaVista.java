package vista;

import javax.swing.*;
import java.awt.*;


public class AgregarRecetaVista extends JFrame {
    private JTextField nombreField;
    private JTextArea ingredientesArea;
    private JTextArea pasosArea;
    private JComboBox<String> categoriaComboBox;
    private JButton agregarButton;

   
    public AgregarRecetaVista() {
        setTitle("Agregar Receta");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 240, 240));

        // Título
        JLabel tituloLabel = new JLabel("Agregar Nueva Receta");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(tituloLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel nombreLabel = new JLabel("Nombre de la Receta:");
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nombreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setFont(new Font("Arial", Font.PLAIN, 16));
        nombreField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nombreField.getPreferredSize().height));
        panelPrincipal.add(nombreField);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel ingredientesLabel = new JLabel("Ingredientes:");
        ingredientesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ingredientesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(ingredientesLabel);

        ingredientesArea = new JTextArea();
        ingredientesArea.setFont(new Font("Arial", Font.PLAIN, 16));
        ingredientesArea.setLineWrap(true);
        ingredientesArea.setWrapStyleWord(true);
        JScrollPane ingredientesScrollPane = new JScrollPane(ingredientesArea);
        ingredientesScrollPane.setPreferredSize(new Dimension(400, 100));
        panelPrincipal.add(ingredientesScrollPane);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel pasosLabel = new JLabel("Pasos:");
        pasosLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        pasosLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(pasosLabel);

        pasosArea = new JTextArea();
        pasosArea.setFont(new Font("Arial", Font.PLAIN, 16));
        pasosArea.setLineWrap(true);
        pasosArea.setWrapStyleWord(true);
        JScrollPane pasosScrollPane = new JScrollPane(pasosArea);
        pasosScrollPane.setPreferredSize(new Dimension(400, 100));
        panelPrincipal.add(pasosScrollPane);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoriaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(categoriaLabel);

        categoriaComboBox = new JComboBox<>(new String[]{"Entradas", "Platos Fuertes", "Postres"});
        categoriaComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        categoriaComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, categoriaComboBox.getPreferredSize().height));
        panelPrincipal.add(categoriaComboBox);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        agregarButton = new JButton("Agregar Receta");
        agregarButton.setFont(new Font("Arial", Font.BOLD, 18));
        agregarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        agregarButton.setBackground(new Color(76, 175, 80));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelPrincipal.add(agregarButton);

        add(panelPrincipal, BorderLayout.CENTER);

        setVisible(true);
    }


    public String getNombre() {
        return nombreField.getText().trim();
    }


    public String getIngredientes() {
        return ingredientesArea.getText().trim();
    }

    public String getPasos() {
        return pasosArea.getText().trim();
    }


    public String getCategoria() {
        return (String) categoriaComboBox.getSelectedItem();
    }


    public JButton getAgregarButton() {
        return agregarButton;
    }
}

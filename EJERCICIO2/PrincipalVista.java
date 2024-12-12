package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class PrincipalVista extends JFrame {
    private JTextField barraBusqueda;
    private JButton botonBuscar;
    private JButton botonTuCuenta;
    private JPanel panelCategorias;
    private JLabel etiquetaIngredientes;
    private JComboBox<String> comboIngredientes;

    public PrincipalVista() {
        setTitle("PicaApp - Inicio");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        Color naranja = new Color(255, 127, 39);
        Color grisClaro = new Color(245, 245, 245);

        // Panel superior con barra de búsqueda y botón de cuenta
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelLogo = new JPanel(new BorderLayout());
        panelLogo.setBackground(grisClaro);

        ImageIcon logoIcon = new ImageIcon("ruta/a/tu/logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel labelLogo = new JLabel(new ImageIcon(logoImage));
        labelLogo.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel labelNombre = new JLabel("PicaApp", SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 24));
        labelNombre.setForeground(naranja);

        panelLogo.add(labelLogo, BorderLayout.WEST);
        panelLogo.add(labelNombre, BorderLayout.CENTER);

        // Barra de búsqueda con texto por defecto -> para el usuario
        barraBusqueda = new JTextField("Buscar receta por ingrediente");
        barraBusqueda.setForeground(Color.GRAY);
        barraBusqueda.setFont(new Font("Arial", Font.PLAIN, 16));
        barraBusqueda.setPreferredSize(new Dimension(300, 30));

        // Cambiar el color del texto cuando el usuario hace clic en la barra de búsqueda*
        barraBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (barraBusqueda.getText().equals("Buscar receta por ingrediente")) {
                    barraBusqueda.setText("");
                    barraBusqueda.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (barraBusqueda.getText().isEmpty()) {
                    barraBusqueda.setText("Buscar receta por ingrediente");
                    barraBusqueda.setForeground(Color.GRAY);
                }
            }
        });

        botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(naranja);
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelBusqueda.add(barraBusqueda, BorderLayout.CENTER);
        panelBusqueda.add(botonBuscar, BorderLayout.EAST);

        botonTuCuenta = new JButton("Tu Cuenta");
        botonTuCuenta.setBackground(grisClaro);
        botonTuCuenta.setForeground(naranja);
        botonTuCuenta.setFont(new Font("Arial", Font.BOLD, 16));

        ImageIcon iconoUsuario = new ImageIcon("D:\\JAVA-P\\PicaApp\\PERFIL1.jpeg");
        Image imagenPerfil = iconoUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel labelIconoUsuario = new JLabel(new ImageIcon(imagenPerfil));

        JPanel panelCuenta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelCuenta.add(botonTuCuenta);
        panelCuenta.add(labelIconoUsuario);

        panelSuperior.add(panelLogo, BorderLayout.NORTH);
        panelSuperior.add(panelBusqueda, BorderLayout.CENTER);
        panelSuperior.add(panelCuenta, BorderLayout.EAST);

        JPanel panelIntermedio = new JPanel(new BorderLayout());
        panelIntermedio.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        etiquetaIngredientes = new JLabel("Selecciona un ingrediente para buscar recetas:");
        etiquetaIngredientes.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaIngredientes.setHorizontalAlignment(SwingConstants.CENTER);

        List<String> ingredientesDisponibles = Arrays.asList(
                "Pollo", "Carne", "Pescado", "Tomate", "Lechuga", "Cebolla", "Zanahoria", "Arroz", "Pasta"
        );
        comboIngredientes = new JComboBox<>(ingredientesDisponibles.toArray(new String[0]));
        comboIngredientes.setFont(new Font("Arial", Font.PLAIN, 14));
        comboIngredientes.setPreferredSize(new Dimension(200, 10)); 

        panelIntermedio.add(etiquetaIngredientes, BorderLayout.NORTH);
        panelIntermedio.add(comboIngredientes, BorderLayout.CENTER);

        panelCategorias = new JPanel(new GridLayout(1, 3, 10, 10));
        panelCategorias.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] categorias = {"Entradas", "Platos Fuertes", "Postres"};
        String[] rutasImagenes = {
                "D:\\JAVA-P\\PicaApp\\LOGO_Entradas.jpeg",
                "D:\\JAVA-P\\PicaApp\\LOGO_Platos_Fuertes.jpeg",
                "D:\\JAVA-P\\PicaApp\\LOGO_Postres.jpeg"
        };
        for (int i = 0; i < categorias.length; i++) {
            JPanel tarjetaCategoria = crearTarjetaCategoria(categorias[i], rutasImagenes[i]);
            panelCategorias.add(tarjetaCategoria);
        }

        add(panelSuperior, BorderLayout.NORTH);
        add(panelIntermedio, BorderLayout.CENTER);
        add(panelCategorias, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel crearTarjetaCategoria(String categoria, String rutaImagen) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setName(categoria);

        ImageIcon imagenIcon = new ImageIcon(rutaImagen);
        Image imagenRedimensionada = imagenIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(imagenRedimensionada));

        JLabel labelTexto = new JLabel(categoria);
        labelTexto.setFont(new Font("Arial", Font.BOLD, 16));

        panel.setLayout(new BorderLayout());
        panel.add(labelImagen, BorderLayout.CENTER);
        panel.add(labelTexto, BorderLayout.SOUTH);

        return panel;
    }

    public void addBuscarListener(ActionListener listener) {
        botonBuscar.addActionListener(listener);
    }

    public JPanel getPanelCategorias() {
        return panelCategorias;
    }

    public void addTuCuentaListener(ActionListener listener) {
        botonTuCuenta.addActionListener(listener);
    }

    public String getTextoBusqueda() {
        return barraBusqueda.getText();
    }

    public String getIngredienteSeleccionado() {
        return (String) comboIngredientes.getSelectedItem();
    }
}

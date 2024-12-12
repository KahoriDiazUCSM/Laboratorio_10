package controlador;

import modelo.*;
import vista.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Controlador {
    private UsuarioModelo usuarioModelo;
    private RecetaModelo recetaModelo;
    private InicioSesionVista inicioSesionVista;
    private RegistroVista registroVista;
    private PrincipalVista principalVista;
    private MiCuentaVista miCuentaVista;
    private int usuarioId;

    public Controlador() {
        usuarioModelo = new UsuarioModelo();
        recetaModelo = new RecetaModelo();
        mostrarInicioSesionVista();
    }

    private void mostrarInicioSesionVista() {
        inicioSesionVista = new InicioSesionVista();

        inicioSesionVista.getIniciarSesionButton().addActionListener(e -> iniciarSesion());
        inicioSesionVista.getRegistroButton().addActionListener(e -> {
            inicioSesionVista.dispose();
            mostrarRegistroVista();
        });
        inicioSesionVista.getRecuperarContrasenaButton().addActionListener(e -> recuperarContrasena());
    }

    private void mostrarRegistroVista() {
        registroVista = new RegistroVista();

        registroVista.getRegistrarButton().addActionListener(e -> registrarUsuario());
        registroVista.getVolverButton().addActionListener(e -> {
            registroVista.dispose();
            mostrarInicioSesionVista();
        });
    }

    private void iniciarSesion() {
        String nombreUsuario = inicioSesionVista.getNombreUsuarioField().getText().trim();
        String contrasena = new String(inicioSesionVista.getContrasenaField().getPassword()).trim();

        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(inicioSesionVista, "Por favor, complete todos los campos.");
            return;
        }

        try {
            if (usuarioModelo.verificarUsuario(nombreUsuario, contrasena)) {
                inicioSesionVista.dispose();
                usuarioId = usuarioModelo.obtenerIdPorNombreUsuario(nombreUsuario);
                mostrarPrincipalVista();
            } else {
                JOptionPane.showMessageDialog(inicioSesionVista, "Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicioSesionVista, "Error al iniciar sesión: " + e.getMessage());
        }
    }

    private void registrarUsuario() {
        String nombreUsuario = registroVista.getNombreUsuarioField().getText().trim();
        String correo = registroVista.getCorreoField().getText().trim();
        String contrasena = new String(registroVista.getContrasenaField().getPassword()).trim();
        String confirmarContrasena = new String(registroVista.getConfirmarContrasenaField().getPassword()).trim();

        if (nombreUsuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(registroVista, "Por favor, complete todos los campos.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(registroVista, "Las contraseñas no coinciden.");
            return;
        }

        try {
            if (usuarioModelo.existeUsuario(nombreUsuario)) {
                JOptionPane.showMessageDialog(registroVista, "El nombre de usuario ya está registrado.");
                return;
            }

            if (usuarioModelo.existeCorreo(correo)) {
                JOptionPane.showMessageDialog(registroVista, "El correo ya está registrado.");
                return;
            }

            if (usuarioModelo.registrarUsuario(nombreUsuario, correo, contrasena)) {
                JOptionPane.showMessageDialog(registroVista, "Registro exitoso.");
                registroVista.dispose();
                mostrarInicioSesionVista();
            } else {
                JOptionPane.showMessageDialog(registroVista, "Error en el registro.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(registroVista, "Error al registrar usuario: " + e.getMessage());
        }
    }

    private void recuperarContrasena() {
        String correo = JOptionPane.showInputDialog(inicioSesionVista, "Introduce tu correo electrónico:");
        if (correo != null && !correo.trim().isEmpty()) {
            String resultado = usuarioModelo.recuperarContrasena(correo);
            JOptionPane.showMessageDialog(inicioSesionVista, resultado);
        } else {
            JOptionPane.showMessageDialog(inicioSesionVista, "Por favor, ingresa un correo válido.");
        }
    }

    private void mostrarPrincipalVista() {
        principalVista = new PrincipalVista();

        agregarListenersCategorias();

        principalVista.addBuscarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRecetasPorIngredientes();
            }
        });

        principalVista.addTuCuentaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMiCuentaVista();
            }
        });

        principalVista.setVisible(true);
    }

    private void agregarListenersCategorias() {
        for (java.awt.Component component : principalVista.getPanelCategorias().getComponents()) {
            if (component instanceof JPanel) {
                component.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String categoria = ((JPanel) component).getName();
                        mostrarRecetasPorCategoria(categoria);
                    }
                });
            }
        }
    }

    private void guardarReceta(int recetaId, int usuarioId) {
        boolean guardado = recetaModelo.guardarReceta(recetaId, usuarioId);
        if (guardado) {
            JOptionPane.showMessageDialog(null, "Receta guardada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "La receta ya está guardada por el usuario.");
        }
    }

    private void mostrarRecetasPorCategoria(String categoria) {
        List<Receta> recetas = recetaModelo.obtenerRecetasPorCategoria(categoria);
        if (!recetas.isEmpty()) {
            new RecetasVista(recetas, usuarioId, recetaModelo);
        } else {
            JOptionPane.showMessageDialog(principalVista, "No hay recetas disponibles para esta categoría.");
        }
    }

    private void buscarRecetasPorIngredientes() {
        String ingrediente = principalVista.getIngredienteSeleccionado();
        if (ingrediente == null || ingrediente.isEmpty()) {
            JOptionPane.showMessageDialog(principalVista, "Por favor, selecciona un ingrediente.");
            return;
        }

        //buscar recetas por ingrediente
        List<Receta> recetas = recetaModelo.buscarRecetasPorIngredientes(ingrediente);

        //Mostrar las recetas encontradas
        mostrarRecetas(recetas);
    }


    private void mostrarRecetas(List<Receta> recetas) {
        if (recetas == null || recetas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron recetas con ese ingrediente.");
            return;
        }

        // Crear una nueva ventana para mostrar las recetas
        JFrame ventanaRecetas = new JFrame("Recetas Encontradas");
        ventanaRecetas.setSize(600, 400);
        ventanaRecetas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRecetas.setLayout(new BorderLayout());

        // Crear un panel para mostrar las recetas
        JPanel panelRecetas = new JPanel();
        panelRecetas.setLayout(new BoxLayout(panelRecetas, BoxLayout.Y_AXIS));
        panelRecetas.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Agregar cada receta al panel
        for (Receta receta : recetas) {
            JButton botonReceta = new JButton(receta.getNombre());
            botonReceta.setFont(new Font("Arial", Font.BOLD, 16));
            botonReceta.setBackground(new Color(33, 150, 243));
            botonReceta.setForeground(Color.WHITE);
            botonReceta.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Agregar un ActionListener para mostrar los detalles de la receta
            botonReceta.addActionListener(e -> {
                mostrarDetalleReceta(receta);
            });

            panelRecetas.add(botonReceta);
            panelRecetas.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Agregar el panel a la ventana
        JScrollPane scrollPane = new JScrollPane(panelRecetas);
        ventanaRecetas.add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        ventanaRecetas.setVisible(true);
    }

    
    private void mostrarMiCuentaVista() {
        String nombreUsuario = usuarioModelo.obtenerNombreUsuarioPorId(usuarioId);

        miCuentaVista = new MiCuentaVista(nombreUsuario);

        miCuentaVista.getBotonAgregarReceta().addActionListener(e -> mostrarFormularioCrearReceta());

        miCuentaVista.getBotonRecetasCreadas().addActionListener(e -> mostrarRecetasCreadas());

        miCuentaVista.getBotonRecetasGuardadas().addActionListener(e -> mostrarRecetasGuardadas());
    }

    private void mostrarRecetasCreadas() {
        List<Receta> recetas = recetaModelo.obtenerRecetasPorUsuario(usuarioId);
        if (!recetas.isEmpty()) {
            for (Receta receta : recetas) {
                mostrarDetalleReceta(receta);
            }
        } else {
            JOptionPane.showMessageDialog(miCuentaVista, "No has creado ninguna receta.");
        }
    }

    private void mostrarRecetasGuardadas() {
        List<Receta> recetas = recetaModelo.obtenerRecetasGuardadasPorUsuario(usuarioId);
        if (!recetas.isEmpty()) {
            new RecetasGuardadasVista(recetas, usuarioId, recetaModelo);
        } else {
            JOptionPane.showMessageDialog(miCuentaVista, "No tienes recetas guardadas.");
        }
    }

    private void mostrarDetalleReceta(Receta receta) {
        // Crear una nueva ventana para mostrar los detalles de la receta
        JFrame ventanaDetalle = new JFrame("Detalle de la Receta: " + receta.getNombre());
        ventanaDetalle.setSize(600, 400);
        ventanaDetalle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaDetalle.setLayout(new BorderLayout());

        // Crear un panel para mostrar los detalles
        JPanel panelDetalle = new JPanel();
        panelDetalle.setLayout(new BoxLayout(panelDetalle, BoxLayout.Y_AXIS));
        panelDetalle.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Mostrar el nombre de la receta
        JLabel labelNombre = new JLabel("Nombre: " + receta.getNombre());
        labelNombre.setFont(new Font("Arial", Font.BOLD, 18));
        panelDetalle.add(labelNombre);

        // Mostrar los ingredientes
        JLabel labelIngredientes = new JLabel("Ingredientes: " + receta.getIngredientes());
        labelIngredientes.setFont(new Font("Arial", Font.PLAIN, 16));
        panelDetalle.add(labelIngredientes);

        // Mostrar los pasos
        JLabel labelPasos = new JLabel("Pasos: " + receta.getPasos());
        labelPasos.setFont(new Font("Arial", Font.PLAIN, 16));
        panelDetalle.add(labelPasos);

        // Agregar el panel a la ventana
        ventanaDetalle.add(panelDetalle, BorderLayout.CENTER);

        // Mostrar la ventana
        ventanaDetalle.setVisible(true);
    }

    private void mostrarFormularioCrearReceta() {
        AgregarRecetaVista agregarRecetaVista = new AgregarRecetaVista();

        agregarRecetaVista.getAgregarButton().addActionListener(e -> {
            String nombre = agregarRecetaVista.getNombre();
            String ingredientes = agregarRecetaVista.getIngredientes();
            String pasos = agregarRecetaVista.getPasos();
            String categoria = agregarRecetaVista.getCategoria();

            if (nombre.isEmpty() || ingredientes.isEmpty() || pasos.isEmpty()) {
                JOptionPane.showMessageDialog(agregarRecetaVista, "Por favor, complete todos los campos.");
                return;
            }

            boolean registrado = recetaModelo.registrarReceta(nombre, ingredientes, pasos, categoria, usuarioId);
            if (registrado) {
                JOptionPane.showMessageDialog(agregarRecetaVista, "Receta agregada correctamente.");
                agregarRecetaVista.dispose();
            } else {
                JOptionPane.showMessageDialog(agregarRecetaVista, "Error al agregar la receta.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Controlador());
    }
}

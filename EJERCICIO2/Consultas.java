package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultas {

    // Métodos CRUD para Usuario

    public boolean registrarUsuario(String nombreUsuario, String correo, String contrasena) {
        String sql = "INSERT INTO USUARIO (nombre_usuario, correo, contrasena) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, correo);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean existeUsuario(String nombreUsuario) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE nombre_usuario = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error al verificar usuario: " + e.getMessage());
            return false;
        }
    }

    public int obtenerIdPorNombreUsuario(String nombreUsuario) {
        String sql = "SELECT id FROM USUARIO WHERE nombre_usuario = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener ID del usuario: " + e.getMessage());
        }
        return -1;
    }

    public boolean existeCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE correo = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error al verificar correo: " + e.getMessage());
            return false;
        }
    }

    public boolean verificarUsuario(String nombreUsuario, String contrasena) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE nombre_usuario = ? AND contrasena = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }

    public String obtenerNombreUsuarioPorId(int usuarioId) {
        String sql = "SELECT nombre_usuario FROM USUARIO WHERE id = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre_usuario");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el nombre de usuario: " + e.getMessage());
        }
        return "Desconocido";
    }

    public String recuperarContrasena(String correo) {
        String sql = "SELECT nombre_usuario, contrasena FROM USUARIO WHERE correo = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return "Usuario: " + rs.getString("nombre_usuario") + "\nContraseña: " + rs.getString("contrasena");
            } else {
                return "Correo no registrado.";
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar credenciales: " + e.getMessage());
            return "Error en el sistema.";
        }
    }

    // Métodos CRUD para Receta

    public boolean registrarReceta(String nombre, String ingredientes, String pasos, String categoria, int usuarioId) {
        String sql = "INSERT INTO RECETAS (nombre, ingredientes, pasos, categoria, usuario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, ingredientes);
            stmt.setString(3, pasos);
            stmt.setString(4, categoria);
            stmt.setInt(5, usuarioId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar receta: " + e.getMessage());
            return false;
        }
    }

    public List<Receta> obtenerRecetasPorUsuario(int usuarioId) {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM RECETAS WHERE usuario_id = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receta receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("pasos"),
                        rs.getString("categoria"),
                        rs.getInt("usuario_id")
                );
                recetas.add(receta);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener recetas por usuario: " + e.getMessage());
        }
        return recetas;
    }

    public List<Receta> obtenerRecetasPorCategoria(String categoria) {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM RECETAS WHERE categoria = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receta receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("pasos"),
                        rs.getString("categoria"),
                        rs.getInt("usuario_id")
                );
                recetas.add(receta);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener recetas por categoría: " + e.getMessage());
        }
        return recetas;
    }

    public List<Receta> buscarRecetasPorIngredientes(String ingredientes) {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM RECETAS WHERE ingredientes LIKE ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + ingredientes + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receta receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("pasos"),
                        rs.getString("categoria"),
                        rs.getInt("usuario_id")
                );
                recetas.add(receta);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar recetas por ingredientes: " + e.getMessage());
        }
        return recetas;
    }

    public boolean guardarReceta(int recetaId, int usuarioId) {
        if (estaRecetaGuardada(recetaId, usuarioId)) {
            System.err.println("La receta ya está guardada por el usuario.");
            return false;
        }

        String sql = "INSERT INTO RECETAS_GUARDADAS (usuario_id, receta_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, recetaId);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar la receta: " + e.getMessage());
            return false;
        }
    }

    private boolean estaRecetaGuardada(int recetaId, int usuarioId) {
        String sql = "SELECT * FROM RECETAS_GUARDADAS WHERE usuario_id = ? AND receta_id = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, recetaId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar si la receta está guardada: " + e.getMessage());
            return false;
        }
    }

    
    public int obtenerUsuarioIdPorReceta(int recetaId) {
        String sql = "SELECT usuario_id FROM RECETAS WHERE id = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, recetaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("usuario_id");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el ID del usuario por receta: " + e.getMessage());
        }
        return -1; 
    }
    
    public List<Receta> obtenerRecetasGuardadasPorUsuario(int usuarioId) {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT r.* FROM RECETAS r JOIN RECETAS_GUARDADAS rg ON r.id = rg.receta_id WHERE rg.usuario_id = ?";
        try (Connection conn = DatabaseConexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receta receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("pasos"),
                        rs.getString("categoria"),
                        rs.getInt("usuario_id")
                );
                recetas.add(receta);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener recetas guardadas: " + e.getMessage());
        }
        return recetas;
    }
}

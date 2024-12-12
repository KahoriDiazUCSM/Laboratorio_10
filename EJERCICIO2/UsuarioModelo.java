package modelo;

public class UsuarioModelo {
    private Consultas consultas;

    public UsuarioModelo() {
        this.consultas = new Consultas();
    }

    public boolean registrarUsuario(String nombreUsuario, String correo, String contrasena) {
        return consultas.registrarUsuario(nombreUsuario, correo, contrasena);
    }

    public boolean existeUsuario(String nombreUsuario) {
        return consultas.existeUsuario(nombreUsuario);
    }

    public int obtenerIdPorNombreUsuario(String nombreUsuario) {
        return consultas.obtenerIdPorNombreUsuario(nombreUsuario);
    }

    public boolean existeCorreo(String correo) {
        return consultas.existeCorreo(correo);
    }

    public boolean verificarUsuario(String nombreUsuario, String contrasena) {
        return consultas.verificarUsuario(nombreUsuario, contrasena);
    }

    public String obtenerNombreUsuarioPorId(int usuarioId) {
        return consultas.obtenerNombreUsuarioPorId(usuarioId);
    }

    public String recuperarContrasena(String correo) {
        return consultas.recuperarContrasena(correo);
    }
}

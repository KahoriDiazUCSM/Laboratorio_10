package modelo;

public class IniciarSesionCommand implements Command {
    private Consultas consultas;
    private String nombreUsuario;
    private String contrasena;

    public IniciarSesionCommand(Consultas consultas, String nombreUsuario, String contrasena) {
        this.consultas = consultas;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    @Override
    public void execute() {
        consultas.verificarUsuario(nombreUsuario, contrasena);
    }
}

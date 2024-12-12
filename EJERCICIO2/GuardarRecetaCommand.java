package modelo;

public class GuardarRecetaCommand implements Command {
    private Consultas consultas;
    private int recetaId;
    private int usuarioId;

    public GuardarRecetaCommand(Consultas consultas, int recetaId, int usuarioId) {
        this.consultas = consultas;
        this.recetaId = recetaId;
        this.usuarioId = usuarioId;
    }

    @Override
    public void execute() {
        consultas.guardarReceta(recetaId, usuarioId);
    }
}

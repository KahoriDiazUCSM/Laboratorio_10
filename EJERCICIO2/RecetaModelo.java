package modelo;

import java.util.List;

public class RecetaModelo {
    private Consultas consultas;

    public RecetaModelo() {
        this.consultas = new Consultas();
    }

    public boolean registrarReceta(String nombre, String ingredientes, String pasos, String categoria, int usuarioId) {
        return consultas.registrarReceta(nombre, ingredientes, pasos, categoria, usuarioId);
    }

    public List<Receta> obtenerRecetasPorUsuario(int usuarioId) {
        return consultas.obtenerRecetasPorUsuario(usuarioId);
    }

    public List<Receta> obtenerRecetasPorCategoria(String categoria) {
        return consultas.obtenerRecetasPorCategoria(categoria);
    }

    public List<Receta> buscarRecetasPorIngredientes(String ingredientes) {
        return consultas.buscarRecetasPorIngredientes(ingredientes);
    }

    public boolean guardarReceta(int recetaId, int usuarioId) {
        return consultas.guardarReceta(recetaId, usuarioId);
    }
    
    public String obtenerNombreUsuarioPorReceta(int recetaId) {
        int usuarioId = consultas.obtenerUsuarioIdPorReceta(recetaId);

        return consultas.obtenerNombreUsuarioPorId(usuarioId);
    }
    
    public List<Receta> obtenerRecetasGuardadasPorUsuario(int usuarioId) {
        return consultas.obtenerRecetasGuardadasPorUsuario(usuarioId);
    }
}

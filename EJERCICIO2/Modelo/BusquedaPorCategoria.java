package modelo;

import java.util.List;

public class BusquedaPorCategoria implements BusquedaStrategy {
    private Consultas consultas;

    public BusquedaPorCategoria(Consultas consultas) {
        this.consultas = consultas;
    }

    @Override
    public List<Receta> buscar(String categoria) {
        return consultas.obtenerRecetasPorCategoria(categoria);
    }
}

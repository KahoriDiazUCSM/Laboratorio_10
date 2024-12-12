package modelo;

import java.util.List;

public class BusquedaPorIngredientes implements BusquedaStrategy {
    private Consultas consultas;

    public BusquedaPorIngredientes(Consultas consultas) {
        this.consultas = consultas;
    }

    @Override
    public List<Receta> buscar(String ingredientes) {
        return consultas.buscarRecetasPorIngredientes(ingredientes);
    }
}

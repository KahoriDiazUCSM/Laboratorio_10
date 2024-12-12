package modelo;

import java.util.List;

public interface BusquedaStrategy {
    List<Receta> buscar(String criterio);
}

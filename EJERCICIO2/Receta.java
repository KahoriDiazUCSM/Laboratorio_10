package modelo;

public class Receta {
    private int id;
    private String nombre;
    private String ingredientes;
    private String pasos;
    private String categoria;
    private int usuarioId;

    public Receta(int id, String nombre, String ingredientes, String pasos, String categoria, int usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getUsuarioId() {
        return usuarioId;
    }
}

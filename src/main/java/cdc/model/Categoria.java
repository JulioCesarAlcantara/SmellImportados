package cdc.model;

/**
 *
 * @author erik
 */
public class Categoria {
    
    private int idCategoria;
    private String name;

    public Categoria() {
    }

    public Categoria(int idCategoria, String name) {
        this.idCategoria = idCategoria;
        this.name = name;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}

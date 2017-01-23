package cdc.model;

/**
 *
 * @author erik
 */
public class Estado {
    
    private int idEstado;
    private String estadoNome;
    private String estadoSigla;

    public Estado() {
    }

    public Estado(int idEstado, String estadoNome, String estadoSigla) {
        this.idEstado = idEstado;
        this.estadoNome = estadoNome;
        this.estadoSigla = estadoSigla;
    }

    public Estado(String estadoNome, String estadoSigla) {
        this.estadoNome = estadoNome;
        this.estadoSigla = estadoSigla;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }

    public String getEstadoSigla() {
        return estadoSigla;
    }

    public void setEstadoSigla(String estadoSigla) {
        this.estadoSigla = estadoSigla;
    }
    
    
    
}

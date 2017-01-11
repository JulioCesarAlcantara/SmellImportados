package cdc.model;

/**
 *
 * @author erik
 */
public class Cidade {

private int idCidade;
private String nomeCidade;
private int idEstadoCidade;

    public Cidade() {
    }

    public Cidade(int idCidade, String nomeCidade, int idEstadoCidade) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstadoCidade = idEstadoCidade;
    }

    public Cidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdEstadoCidade() {
        return idEstadoCidade;
    }

    public void setIdEstadoCidade(int idEstadoCidade) {
        this.idEstadoCidade = idEstadoCidade;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

/**
 *
 * @author erik
 */
public class Promocao {
    
    private int idPromocao;
    private String nomePromocao;
    private String dataInicioPromocao;
    private String dataFimPromocao;
    private float descontoPromocao;
    private String statusPromocao;
    private int idProdutoPromocao;

    public Promocao() {
    }

    public Promocao(int idPromocao, String nomePromocao, String dataInicioPromocao, String dataFimPromocao, float descontoPromocao, String statusPromocao, int idProdutoPromocao) {
        this.idPromocao = idPromocao;
        this.nomePromocao = nomePromocao;
        this.dataInicioPromocao = dataInicioPromocao;
        this.dataFimPromocao = dataFimPromocao;
        this.descontoPromocao = descontoPromocao;
        this.statusPromocao = statusPromocao;
        this.idProdutoPromocao = idProdutoPromocao;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public String getDataInicioPromocao() {
        return dataInicioPromocao;
    }

    public void setDataInicioPromocao(String dataInicioPromocao) {
        this.dataInicioPromocao = dataInicioPromocao;
    }

    public String getDataFimPromocao() {
        return dataFimPromocao;
    }

    public void setDataFimPromocao(String dataFimPromocao) {
        this.dataFimPromocao = dataFimPromocao;
    }

    public float getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(float descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public String getStatusPromocao() {
        return statusPromocao;
    }

    public void setStatusPromocao(String statusPromocao) {
        this.statusPromocao = statusPromocao;
    }

    public int getIdProdutoPromocao() {
        return idProdutoPromocao;
    }

    public void setIdProdutoPromocao(int idProdutoPromocao) {
        this.idProdutoPromocao = idProdutoPromocao;
    }
    
    
    
}

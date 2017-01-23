/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

import java.sql.Date;

/**
 *
 * @author erik
 */
public class Promocao {
    
    private int idPromocao;
    private String nomePromocao;
    private Date dataInicioPromocao;
    private Date dataFimPromocao;
    private float descontoPromocao;
    private String statusPromocao;

    public Promocao() {
    }

    public Promocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
    
    

    public Promocao(int idPromocao, String nomePromocao, Date dataInicioPromocao, Date dataFimPromocao, float descontoPromocao, String statusPromocao) {
        this.idPromocao = idPromocao;
        this.nomePromocao = nomePromocao;
        this.dataInicioPromocao = dataInicioPromocao;
        this.dataFimPromocao = dataFimPromocao;
        this.descontoPromocao = descontoPromocao;
        this.statusPromocao = statusPromocao;
    }

    public Promocao(String nomePromocao, Date dataInicioPromocao, Date dataFimPromocao, float descontoPromocao, String statusPromocao) {
        this.nomePromocao = nomePromocao;
        this.dataInicioPromocao = dataInicioPromocao;
        this.dataFimPromocao = dataFimPromocao;
        this.descontoPromocao = descontoPromocao;
        this.statusPromocao = statusPromocao;
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

    public Date getDataInicioPromocao() {
        return dataInicioPromocao;
    }

    public void setDataInicioPromocao(Date dataInicioPromocao) {
        this.dataInicioPromocao = dataInicioPromocao;
    }

    public Date getDataFimPromocao() {
        return dataFimPromocao;
    }

    public void setDataFimPromocao(Date dataFimPromocao) {
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
    
    
}

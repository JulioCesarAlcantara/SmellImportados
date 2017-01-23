/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

/**
 *
 * @author cesar
 */
public class PalavrasChave {
    private int idPalavraChave; 
    private String palavra1; 
    private String palavra2; 
    private String palavra3; 
    private int idProduto; 

    public PalavrasChave() {
    }

    public PalavrasChave( String palavra1, String palavra2, String palavra3, int idProduto) {
        this.palavra1 = palavra1;
        this.palavra2 = palavra2;
        this.palavra3 = palavra3;
        this.idProduto = idProduto;
    }

    public int getIdPalavraChave() {
        return idPalavraChave;
    }

    public void setIdPalavraChave(int idPalavraChave) {
        this.idPalavraChave = idPalavraChave;
    }

    public String getPalavra1() {
        return palavra1;
    }

    public void setPalavra1(String palavra1) {
        this.palavra1 = palavra1;
    }

    public String getPalavra2() {
        return palavra2;
    }

    public void setPalavra2(String palavra2) {
        this.palavra2 = palavra2;
    }

    public String getPalavra3() {
        return palavra3;
    }

    public void setPalavra3(String palavra3) {
        this.palavra3 = palavra3;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}

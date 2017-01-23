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
public class ProdutoPromocao {
    
    private int idProdutoPromocao;
    private int idProduto;
    private int idPromocao;

    public ProdutoPromocao(int idProdutoPromocao, int idProduto, int idPromocao) {
        this.idProdutoPromocao = idProdutoPromocao;
        this.idProduto = idProduto;
        this.idPromocao = idPromocao;
    }

    public ProdutoPromocao(int idProduto, int idPromocao) {
        this.idProduto = idProduto;
        this.idPromocao = idPromocao;
    }

    public int getIdProdutoPromocao() {
        return idProdutoPromocao;
    }

    public void setIdProdutoPromocao(int idProdutoPromocao) {
        this.idProdutoPromocao = idProdutoPromocao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
    
    
    
    
}

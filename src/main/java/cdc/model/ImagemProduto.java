/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

import java.sql.Blob;

/**
 *
 * @author cesar
 */
public class ImagemProduto {
    private int idImagem; 
    private Blob imagem1; 
    private Blob imagem2; 
    private Blob imagem3; 
    private int idProduto; 

    public ImagemProduto() {
    }

    public ImagemProduto(int idImagem, Blob imagem1, Blob imagem2, Blob imagem3, int idProduto) {
        this.idImagem = idImagem;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProduto = idProduto;
    }

    public ImagemProduto(Blob imagem1, Blob imagem2, Blob imagem3, int idProduto) {
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProduto = idProduto;
    }
    

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public Blob getImagem1() {
        return imagem1;
    }

    public void setImagem1(Blob imagem1) {
        this.imagem1 = imagem1;
    }

    public Blob getImagem2() {
        return imagem2;
    }

    public void setImagem2(Blob imagem2) {
        this.imagem2 = imagem2;
    }

    public Blob getImagem3() {
        return imagem3;
    }

    public void setImagem3(Blob imagem3) {
        this.imagem3 = imagem3;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}

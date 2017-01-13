package cdc.model;

import java.sql.Blob;

/**
 *
 * @author erik
 */
public class Produto {

    private int idProduto;
    private String nomeProduto;
    private float precoProduto;
    private String descricaoProduto;
    private Blob imagemProduto;
    private int idCategoriaProduto;
    private int idPalavraChave; 

    public Produto() {
    }

    public Produto(Integer idProduto, String nomeProduto, float precoProduto, String descricaoProduto, Blob imagemProduto, Integer idCategoriaProduto, Integer idPalavraChave) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.imagemProduto = imagemProduto;
        this.idCategoriaProduto = idCategoriaProduto;
        this.idPalavraChave = idPalavraChave;
    }

    Produto(Integer idProduto, String nomeProduto, Float precoProduto, Integer idCategoriaProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Blob getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(Blob imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public int getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(int idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public int getIdPalavraChave() {
        return idPalavraChave;
    }

    public void setIdPalavraChave(int idPalavraChave) {
        this.idPalavraChave = idPalavraChave;
    }

}

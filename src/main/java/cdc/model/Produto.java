package cdc.model;

/**
 *
 * @author erik
 */
public class Produto {
    
    private int idProduto;
    private String nomeProduto;
    private float precoProduto;
    private int idCategoriaProduto;

    public Produto() {
    }

    public Produto(int idProduto, String nomeProduto, float precoProduto, int idCategoriaProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public Produto(String nomeProduto, float precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
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

    public int getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(int idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }
    
    
    
}

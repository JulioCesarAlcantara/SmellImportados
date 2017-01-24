package cdc.model;


/**
 *
 * @author erik
 */
public class Produto {

    private String idProduto1; 
    private int idProduto;
    private String nomeProduto;
    private float precoProduto;
    private String descricaoProduto;
    private String categoriaProduto;  
    private int quantidadeProduto; 

    public Produto() {
    }

    
    
    public Produto(String nomeProduto, float precoProduto, String descricaoProduto, String Categoria, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = Categoria;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto(int idProduto, String nomeProduto, float precoProduto, String descricaoProduto, String Categoria, int quantidadeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = Categoria;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdProduto1() {
        return idProduto1;
    }

    public void setIdProduto1(String idProduto1) {
        this.idProduto1 = idProduto1;
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

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    
    
    

}

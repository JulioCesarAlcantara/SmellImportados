package cdc.model;

/**
 *
 * @author erik
 */
public class ItemCompra {
    
    private Integer idItemCompra;
    private Integer idProdutoItemCompra;
    private Integer idUsuarioItemCompra;
    private Integer idProduto;
    private String  nomeProduto;
    private float precoProduto;
    private String descricaoProduto;
    private String categoriaProduto;
    private Integer quantidadeProduto;
    private Integer idImagemProduto;
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private Integer idProdutoImagemDeProduto;

    public ItemCompra() {
    }

    public ItemCompra(Integer idItemCompra, Integer idProdutoItemCompra, Integer idUsuarioItemCompra, Integer idProduto, String nomeProduto, float precoProduto, String descricaoProduto, String categoriaProduto, Integer quantidadeProduto, Integer idImagemProduto, String imagem1, String imagem2, String imagem3, Integer idProdutoImagemDeProduto) {
        this.idItemCompra = idItemCompra;
        this.idProdutoItemCompra = idProdutoItemCompra;
        this.idUsuarioItemCompra = idUsuarioItemCompra;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idImagemProduto = idImagemProduto;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProdutoImagemDeProduto = idProdutoImagemDeProduto;
    }

    public Integer getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(Integer idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public Integer getIdProdutoItemCompra() {
        return idProdutoItemCompra;
    }

    public void setIdProdutoItemCompra(Integer idProdutoItemCompra) {
        this.idProdutoItemCompra = idProdutoItemCompra;
    }

    public Integer getIdUsuarioItemCompra() {
        return idUsuarioItemCompra;
    }

    public void setIdUsuarioItemCompra(Integer idUsuarioItemCompra) {
        this.idUsuarioItemCompra = idUsuarioItemCompra;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
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

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Integer getIdImagemProduto() {
        return idImagemProduto;
    }

    public void setIdImagemProduto(Integer idImagemProduto) {
        this.idImagemProduto = idImagemProduto;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public Integer getIdProdutoImagemDeProduto() {
        return idProdutoImagemDeProduto;
    }

    public void setIdProdutoImagemDeProduto(Integer idProdutoImagemDeProduto) {
        this.idProdutoImagemDeProduto = idProdutoImagemDeProduto;
    }

   
    
}

package cdc.model;


public class ListaImagemProduto {
   
    private Integer idProduto; 
    private String nomeProduto; 
    private float precoProduto;     
    private String descricaoProduto; 
    private String categoriaProduto; 
    private int qntProduto;
    private Integer idImagem; 
    private String imagem1; 
    private String imagem2;
    private String imagem3;
    private Integer idProdutoImagem; 

    public ListaImagemProduto() {
        
    }    

    public ListaImagemProduto(Integer idProduto, String nomeProduto, float precoProduto, String descricaoProduto, String categoriaProduto, int qntProduto, Integer idImagem, String imagem1, Integer idProdutoImagem) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.qntProduto = qntProduto;
        this.idImagem = idImagem;
        this.imagem1 = imagem1;
        this.idProdutoImagem = idProdutoImagem;
    }

    public ListaImagemProduto(Integer idProduto, String nomeproduto, float precoProduto, String descricaoProduto, String categoriaProduto, int qntProduto, Integer idImagem, String imagem1, String imagem2, String imagem3, Integer idProdutoImagem) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeproduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.qntProduto = qntProduto;
        this.idImagem = idImagem;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProdutoImagem = idProdutoImagem;
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

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public Integer getIdProdutoImagem() {
        return idProdutoImagem;
    }

    public void setIdProdutoImagem(Integer idProdutoImagem) {
        this.idProdutoImagem = idProdutoImagem;
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
    
    
    
}

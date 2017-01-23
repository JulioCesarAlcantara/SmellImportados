package cdc.model;
/**
 *
 * @author cesar
 */
public class ImagemProduto {
    private int idImagem; 
    private String imagem1; 
    private String imagem2; 
    private String imagem3; 
    private int idProduto; 

    public ImagemProduto() {
    }

    public ImagemProduto(String imagem1, String imagem2, String imagem3, int idProduto) {
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProduto = idProduto;
    }

    //construtor para teste;
    public ImagemProduto(String imagem1, int idProduto) {
        this.imagem1 = imagem1;
        this.idProduto = idProduto;
    }
    

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
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

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

  
}

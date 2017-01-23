package cdc.model;

/**
 *
 * @author erik
 */
public class ItemCompra {
    
    private Integer idItemCompra;
    private Integer idCompraItemCompra;
    private Integer idProdutoItemCompra;

    public ItemCompra() {
    }

    public ItemCompra(Integer idCompraItemCompra, Integer idProdutoItemCompra) {
        this.idCompraItemCompra = idCompraItemCompra;
        this.idProdutoItemCompra = idProdutoItemCompra;
    }    

    public ItemCompra(Integer idItemCompra, Integer idCompraItemCompra, Integer idProdutoItemCompra) {
        this.idItemCompra = idItemCompra;
        this.idCompraItemCompra = idCompraItemCompra;
        this.idProdutoItemCompra = idProdutoItemCompra;
    }

    public Integer getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(Integer idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public Integer getIdCompraItemCompra() {
        return idCompraItemCompra;
    }

    public void setIdCompraItemCompra(Integer idCompraItemCompra) {
        this.idCompraItemCompra = idCompraItemCompra;
    }

    public Integer getIdProdutoItemCompra() {
        return idProdutoItemCompra;
    }

    public void setIdProdutoItemCompra(Integer idProdutoItemCompra) {
        this.idProdutoItemCompra = idProdutoItemCompra;
    }
    
    
    
}

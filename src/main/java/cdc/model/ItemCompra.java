package cdc.model;

/**
 *
 * @author erik
 */
public class ItemCompra {
    
    private int idItemCompra;
    private int idCompraItemCompra;
    private int idProdutoItemCompra;

    public ItemCompra() {
    }

    public ItemCompra(int idItemCompra, int idCompraItemCompra, int idProdutoItemCompra) {
        this.idItemCompra = idItemCompra;
        this.idCompraItemCompra = idCompraItemCompra;
        this.idProdutoItemCompra = idProdutoItemCompra;
    }

    public int getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(int idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public int getIdCompraItemCompra() {
        return idCompraItemCompra;
    }

    public void setIdCompraItemCompra(int idCompraItemCompra) {
        this.idCompraItemCompra = idCompraItemCompra;
    }

    public int getIdProdutoItemCompra() {
        return idProdutoItemCompra;
    }

    public void setIdProdutoItemCompra(int idProdutoItemCompra) {
        this.idProdutoItemCompra = idProdutoItemCompra;
    }
    
    
    
}

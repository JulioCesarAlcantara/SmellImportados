package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ImagemProdutoDAO implements DAO {

    Connection conn;

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        ImagemProduto ip = (ImagemProduto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (ip == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "insert into ImagemDeProduto (imagem1,imagem2, imagem3) values (?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setBlob(1, ip.getImagem1());
            ps.setBlob(2, ip.getImagem2());
            ps.setBlob(3, ip.getImagem3());
            ps.setInt(4, ip.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public byte[] recuperaImagem(int codimagem) throws Exception {
        Connection conn = ConnectionDAO.getConnection();
        String SQL = "select imagemProduto from Produto";
        PreparedStatement ps = conn.prepareStatement(SQL);

        try {
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                return resultado.getBytes("imagemProduto");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

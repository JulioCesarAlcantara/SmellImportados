package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ImagemProdutoDAO implements DAO {

    Connection conn;

    public ImagemProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        }
    }

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
            String sql = "INSERT INTO ImagemDeProduto (imagem1,imagem2,imagem3,idProduto) VALUES (?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, ip.getImagem1());
            ps.setString(2, ip.getImagem2());
            ps.setString(3, ip.getImagem3());
            ps.setInt(4, ip.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listaProdutosParaCompra(String id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT *  "
                    + "FROM Produto "
                    + "INNER JOIN ImagemDeProduto  "
                    + "ON ImagemDeProduto.idProduto = Produto.idProduto "
                    + "WHERE Produto.idProduto = " + id);
            System.out.println(" PS :  " + ps);
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                list.add(new ListaImagemProduto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), 
                                                rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), 
                                                rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            System.out.println("Lista :  " + list);
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}

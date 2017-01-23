/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erik
 */
public class ProdutoPromocaoDAO implements DAO {

    private Connection conn;

    public ProdutoPromocaoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
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

        ProdutoPromocao prodProm;
        prodProm = (ProdutoPromocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (prodProm == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO ProdutoPromocao (idProdutoProdutoPromocao, idPromocaoProdutoPromocao) VALUES (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, prodProm.getIdProduto());
            ps.setInt(2, prodProm.getIdPromocao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados:\n" + e);
        }
    }

    public List buscaProdutosParaCombo() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from Produto");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                float precoProduto = rs.getFloat(3);
                String descricaoProduto = rs.getString(4);
                String categoriaProduto = rs.getString(5);
                int quantidadeProduto = rs.getInt(6);
                list.add(new Produto(idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }

    }

    public List buscaPromocoesParaCombo() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from Promocao");
            rs = ps.executeQuery();
            List<Promocao> list = new ArrayList<>();
            while (rs.next()) {
                Integer idPromocao = rs.getInt(1);
                String nomePromocao = rs.getString(2);
                Date dataInicioPromocao = rs.getDate(3);
                Date dataFimPromocao = rs.getDate(4);
                float descontoPromocao = rs.getFloat(5);
                String statusPromocao = rs.getString(6);
                list.add(new Promocao(idPromocao, nomePromocao, dataInicioPromocao, dataFimPromocao, descontoPromocao, statusPromocao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }

    }
    
     public List buscaProdutosDeUmaPromocao(int idPromo) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT idProduto, nomeProduto FROM ProdutoPromocao INNER JOIN Promocao ON Promocao.idPromocao = ProdutoPromocao.idPromocaoProdutoPromocao INNER JOIN Produto ON idProduto = idProdutoProdutoPromocao AND idPromocao = ?");
            ps.setInt(1, idPromo);
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                list.add(new Produto(idProduto, nomeProduto, 0, null, null, 0));
            }
            
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }

    }

//    public List buscaProdutosDeUmaPromocao(int idPromo) throws Exception {
//
//        PreparedStatement ps = null;
//        Connection conn = null;
//        ResultSet rs = null;
//
//        try {
//            conn = this.conn;
//            ps = conn.prepareStatement("select idProdutoProdutoPromocao from ProdutoPromocao where idPromocaoProdutoPromocao = ?");
//            ps.setInt(1, idPromo);
//            rs = ps.executeQuery();
//            List<Integer> listIdProdutos = new ArrayList<>();
//            while (rs.next()) {
//                Integer id = rs.getInt(1);
//                listIdProdutos.add(id);
//            }
//            List<Produto> list = buscaDadosDosProdutos(listIdProdutos);
//            return list;
//        } catch (SQLException sqle) {
//            throw new Exception(sqle);
//        } finally {
//            ConnectionDAO.close(conn, ps, rs);
//        }
//
//    }
//
//    public List buscaDadosDosProdutos(List<Integer> listaDeId) throws Exception {
//        PreparedStatement ps = null;
//        Connection conn = null;
//        ResultSet rs = null;
//        List<Produto> produtos;
//        produtos = new ArrayList<>();
//
//        try {
//            conn = this.conn;
//            for (Integer id : listaDeId) {
//                ps = conn.prepareStatement("SELECT * FROM Produto WHERE idProduto = ?");
//                ps.setInt(1, id);
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    Integer idProduto = rs.getInt(1);
//                    String nomeProduto = rs.getString(2);
//                    float precoProduto = rs.getFloat(3);
//                    String descricaoProduto = rs.getString(4);
//                    String categoriaProduto = rs.getString(5);
//                    int quantidadeProduto = rs.getInt(6);
//                    produtos.add(new Produto(idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto));
//                }
//            }
//            return produtos;
//        } catch (SQLException sqle) {
//            throw new Exception(sqle);
//        } finally {
//            ConnectionDAO.close(conn, ps, rs);
//        }
//    }

    public void delete(Integer idProduto, Integer idPromocao) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (idProduto == 0 && idPromocao == 0) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "delete from ProdutoPromocao where idProdutoProdutoPromocao = ? and idPromocaoProdutoPromocao = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, idProduto);
            ps.setInt(2, idPromocao);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

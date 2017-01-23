/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author erik
 */
public class ProdutoDAO implements DAO {

    Connection conn;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Produto com = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update Produto set nomeProduto = ?, precoProduto = ?, idCategoriaProduto where idProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeProduto());
            ps.setFloat(2, com.getPrecoProduto());
            // ps.setInt(3, com.getIdCategoriaProduto());
            ps.setInt(4, com.getIdProduto());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Produto com = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Produto where idProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto,"
                    + " idImagemDeProduto, imagem1,ImagemDeProduto.idProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemDeProduto"
                    + " ON ImagemDeProduto.idProduto = Produto.idProduto");
            rs = ps.executeQuery();
            List<ListaImagemProduto> list = new ArrayList<ListaImagemProduto>();
            while (rs.next()) {
                list.add(new ListaImagemProduto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        Produto com = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Produto ";
            String where = "";
            boolean checa = false;
            /* if (com.getIdProduto() != 0 || com.getNomeProduto() != null || com.getPrecoProduto() != 0 || com.getIdCategoriaProduto() != 0) {
                where = "where ";
                if (com.getIdProduto() != 0) {
                    where += "idProduto=? ";
                    checa = true;
                }
                if (com.getNomeProduto() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " nomeProduto=? ";
                    checa = true;
                }
                if (com.getPrecoProduto() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " precoProduto=? ";
                    checa = true;
                }
                /*if (com.getIdCategoriaProduto() != 0) {
                    if (checa) {    
                        where += "and";
                    }
                    where += " idCategoriaProduto=? ";
                }
            }*/

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            /*if (com.getIdProduto() != 0 || com.getNomeProduto() != null || com.getPrecoProduto() != 0 || com.getIdCategoriaProduto() != 0) {
                if (com.getIdProduto() != 0) {
                    ps.setInt(contaCampos, com.getIdProduto());
                    contaCampos++;
                }
                if (com.getNomeProduto() != null) {
                    ps.setString(contaCampos, com.getNomeProduto());
                    contaCampos++;
                }
                if (com.getPrecoProduto() != 0) {
                    ps.setFloat(contaCampos, com.getPrecoProduto());
                }
               // if (com.getIdCategoriaProduto() != 0) {
               //    ps.setInt(contaCampos, com.getIdCategoriaProduto());
               // }
            }*/
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                Float precoProduto = rs.getFloat(3);
                Integer idCategoriaProduto = rs.getInt(4);
                //list.add(new Produto(idProduto, nomeProduto, precoProduto, idCategoriaProduto));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }

    }

    @Override
    public void salvar(Object ob) throws Exception {
        Produto com = (Produto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "insert into Produto (nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto) values (?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeProduto());
            ps.setFloat(2, com.getPrecoProduto());
            ps.setString(3, com.getDescricaoProduto());
            ps.setString(4, com.getCategoria());
            ps.setInt(5, com.getQuantidadeProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public int buscaIdPeloNome(String str) throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "SELECT idProduto FROM Produto WHERE nomeProduto= '" + str + "'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);

            rs = (ResultSet) ps.executeQuery();
            int id = 0;

            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List buscaProdutoPesquisado(String str) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto,"
                    + " idImagemDeProduto, imagem1,ImagemDeProduto.idProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemDeProduto"
                    + " ON ImagemDeProduto.idProduto = Produto.idProduto "
                    + " WHERE Produto.nomeProduto "
                    + " LIKE '%" + str + "%'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<ListaImagemProduto> list = new ArrayList<ListaImagemProduto>();
            while (rs.next()) {
                list.add(new ListaImagemProduto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    /**
     * Este método é responsável por buscar um determinado produto pra realizar 
     * uma compra. O produto é buscado pelo id e é retornado uma lista contendo 
     * todos seus atributos. 
     * @param id
     * @return
     * @throws Exception 
     */
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
            
            System.out.println("SQL : " + ps);
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

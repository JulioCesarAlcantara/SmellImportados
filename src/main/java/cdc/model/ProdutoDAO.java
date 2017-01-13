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
            ps.setInt(3, com.getIdCategoriaProduto());
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
            ps = conn.prepareStatement("select * from Produto");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                list.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
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
            if (com.getIdProduto() != 0 || com.getNomeProduto() != null || com.getPrecoProduto() != 0 || com.getIdCategoriaProduto() != 0) {
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
                if (com.getIdCategoriaProduto() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " idCategoriaProduto=? ";
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (com.getIdProduto() != 0 || com.getNomeProduto() != null || com.getPrecoProduto() != 0 || com.getIdCategoriaProduto() != 0) {
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
                if (com.getIdCategoriaProduto() != 0) {
                    ps.setInt(contaCampos, com.getIdCategoriaProduto());
                }
            }
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                Float precoProduto = rs.getFloat(3);
                Integer idCategoriaProduto = rs.getInt(4);
                list.add(new Produto(idProduto, nomeProduto, precoProduto, idCategoriaProduto));
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
            String sql = "insert into Produto (nomeProduto, precoProduto, descricaoProduto, imagemProduto, idCategoriaProduto,PalavrasChave_idPalavrasChave) values (?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeProduto());
            ps.setFloat(2, com.getPrecoProduto());
            ps.setString(3, com.getDescricaoProduto());
            ps.setBlob(4, com.getImagemProduto());
            ps.setInt(5, com.getIdCategoriaProduto());
            ps.setInt(6, com.getIdPalavraChave());
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

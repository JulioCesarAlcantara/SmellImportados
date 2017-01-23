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
public class CategoriaDAO implements DAO {

    private Connection conn;

    public CategoriaDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    public void atualizar(Object ob) throws Exception {
        Categoria cat;
        cat = (Categoria) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "update Categoria set nomeCategoria = ? WHERE idCategoria = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cat.getName());
            ps.setInt(2, cat.getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar categoria:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Categoria cat;
        cat = (Categoria) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "delete from Categoria where idCategoria = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cat.getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao apagar categoria:\n" + e);
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
            ps = conn.prepareStatement("select * from categoria");
            rs = ps.executeQuery();
            List<Categoria> list = new ArrayList<Categoria>();
            while (rs.next()) {
                Integer idCategoria = rs.getInt(1);
                String nomeCategoria = rs.getString(2);
                list.add(new Categoria(idCategoria, nomeCategoria));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        Categoria cat = (Categoria) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from categoria ";
            String where = "";
            boolean checa = false;
            if (cat.getIdCategoria()!= 0 || cat.getName()!= null ) {
                where = "where ";
                if (cat.getIdCategoria()!= 0) {
                    where += "idCategoria=? ";
                    checa = true;
                }
                if (cat.getName()!= null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " nomeCategoria=? ";
                    checa = true;
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (cat.getIdCategoria()!= 0 || cat.getName()!= null) {
                if (cat.getIdCategoria()!= 0) {
                    ps.setInt(contaCampos, cat.getIdCategoria());
                    contaCampos++;
                }
                if (cat.getName()!= null) {
                    ps.setString(contaCampos, cat.getName());
                    contaCampos++;
                }
            }
            rs = ps.executeQuery();
            List<Categoria> list = new ArrayList<Categoria>();
            while (rs.next()) {
                Integer idCategoria = rs.getInt(1);
                String nomeCategoria = rs.getString(2);
                list.add(new Categoria(idCategoria, nomeCategoria));
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
    Categoria cat;
        cat = (Categoria) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO Categoria (nomeCategoria) VALUES (?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cat.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados da categoria:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

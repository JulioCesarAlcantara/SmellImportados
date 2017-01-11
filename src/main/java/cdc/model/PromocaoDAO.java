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
public class PromocaoDAO implements DAO {

    private Connection conn;

    public PromocaoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    public void atualizar(Object ob) throws Exception {
        Promocao prom = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (prom == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "update Promocao set nomePromocao = ?, dataInicioPromocao = ?, dataFimPromocao = ?, descontoPromocao=?, statusPromocao=?, idProdutoPromocao=? WHERE idPromocao = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, prom.getNomePromocao());
            ps.setString(2, prom.getDataInicioPromocao());
            ps.setString(3, prom.getDataFimPromocao());
            ps.setFloat(4, prom.getDescontoPromocao());
            ps.setString(5, prom.getStatusPromocao());
            ps.setInt(6, prom.getIdProdutoPromocao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar Promocao:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Promocao cat;
        cat = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "delete from Promocao where idPromocao = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cat.getIdPromocao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao apagar Promocao:\n" + e);
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
            ps = conn.prepareStatement("select * from Promocao");
            rs = ps.executeQuery();
            List<Promocao> list = new ArrayList<Promocao>();
            while (rs.next()) {
                Integer idPromocao = rs.getInt(1);
                String nomePromocao = rs.getString(2);
                String dataInicio = rs.getString(3);
                String dataFim = rs.getString(4);
                float descontoPromo = rs.getFloat(5);
                String statusPromo = rs.getString(6);
                Integer idProdutoPromocao = rs.getInt(7);
                list.add(new Promocao(idPromocao, nomePromocao, dataInicio, dataFim, descontoPromo, statusPromo, idProdutoPromocao));
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
        Promocao cat = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Promocao ";
            String where = "";
            boolean checa = false;
            if (cat.getIdPromocao()!= 0 || cat.getNomePromocao()!= null || cat.getStatusPromocao() != null) {
                where = "where ";
                if (cat.getIdPromocao()!= 0) {
                    where += "idPromocao=? ";
                    checa = true;
                }
                if(cat.getNomePromocao() != null){
                    if (checa) {
                        where += "and";
                    }
                    where +="nomePromocao=? ";
                    checa=true;
                }
                
                if (cat.getStatusPromocao()!= null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " statusPromocao=? ";
                    checa = true;
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (cat.getIdPromocao()!= 0 || cat.getNomePromocao()!= null || cat.getStatusPromocao() != null) {
                if (cat.getIdPromocao()!= 0) {
                    ps.setInt(contaCampos, cat.getIdPromocao());
                    contaCampos++;
                }
                if(cat.getNomePromocao() != null){
                    ps.setString(contaCampos, cat.getNomePromocao());
                    contaCampos++;
                }
                if (cat.getStatusPromocao()!= null) {
                    ps.setString(contaCampos, cat.getStatusPromocao());
                    contaCampos++;
                }
            }
            rs = ps.executeQuery();
            List<Promocao> list = new ArrayList<Promocao>();
            while (rs.next()) {
                Integer idPromocao = rs.getInt(1);
                String nomePromocao = rs.getString(2);
                String dataInicio = rs.getString(3);
                String dataFim = rs.getString(4);
                float descontoPromo = rs.getFloat(5);
                String statusPromo = rs.getString(6);
                Integer idProdutoPromocao = rs.getInt(7);
                list.add(new Promocao(idPromocao, nomePromocao, dataInicio, dataFim, descontoPromo, statusPromo, idProdutoPromocao));
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
    Promocao cat;
        cat = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cat == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO Promocao (nomePromocao, dataInicioPromocao, dataFimPromocao, descontoPromocao, statusPromocao, idProdutoPromocao) VALUES (?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cat.getNomePromocao());
            ps.setString(2, cat.getDataInicioPromocao());
            ps.setString(3, cat.getDataFimPromocao());
            ps.setFloat(4, cat.getDescontoPromocao());
            ps.setString(5, cat.getStatusPromocao());
            ps.setInt(6, cat.getIdProdutoPromocao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados da Promocao:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}


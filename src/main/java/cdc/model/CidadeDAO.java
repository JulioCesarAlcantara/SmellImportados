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
public class CidadeDAO implements DAO {

    private Connection conn;

    public CidadeDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Cidade cid;
        cid = (Cidade) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cid == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "update Cidade set nomeCidade = ?, idEstadoCidade = ? WHERE idCidade = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cid.getNomeCidade());
            ps.setInt(2, cid.getIdEstadoCidade());
            ps.setInt(3, cid.getIdCidade());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar cidade:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    @Override
    public void excluir(Object ob) throws Exception {
        Cidade cid;
        cid = (Cidade) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (cid == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "delete from Cidade where idCidade = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cid.getIdCidade());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao excluir cidade:\n" + e);
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
            ps = conn.prepareStatement("select * from Cidade");
            rs = ps.executeQuery();
            List<Cidade> list = new ArrayList<Cidade>();
            while (rs.next()) {
                Integer idCidade = rs.getInt(1);
                String nomeCidade = rs.getString(2);
                Integer idEstadoCidade = rs.getInt(3);
                list.add(new Cidade(idCidade, nomeCidade, idEstadoCidade));
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
        Cidade cid = (Cidade) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (cid == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Cidade ";
            String where = "";
            boolean checa = false;
            if (cid.getIdCidade()!= 0 || cid.getNomeCidade()!= null || cid.getIdEstadoCidade()!= 0) {
                where = "where ";
                if (cid.getIdCidade()!= 0) {
                    where += "idCidade=? ";
                    checa = true;
                }
                if (cid.getNomeCidade()!= null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " nomeCidade=? ";
                    checa = true;
                }
                if (cid.getIdEstadoCidade()!= 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " idEstadoCidade=? ";
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (cid.getIdCidade()!= 0 || cid.getNomeCidade()!= null || cid.getIdEstadoCidade()!= 0) {
                if (cid.getIdCidade()!= 0) {
                    ps.setInt(contaCampos, cid.getIdCidade());
                    contaCampos++;
                }
                if (cid.getNomeCidade()!= null) {
                    ps.setString(contaCampos, cid.getNomeCidade());
                    contaCampos++;
                }
                if (cid.getIdEstadoCidade()!= 0) {
                    ps.setInt(contaCampos, cid.getIdEstadoCidade());
                }
            }
            rs = ps.executeQuery();
            List<Cidade> list = new ArrayList<Cidade>();
            while (rs.next()) {
                Integer idCidade = rs.getInt(1);
                String nomeCidade = rs.getString(2);
                Integer idEstadoCidade = rs.getInt(3);
                list.add(new Cidade(idCidade, nomeCidade, idEstadoCidade));
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
        Cidade cid = (Cidade) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (cid == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "insert into Cidade (nomeCidade, idEstadoCidade) values (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cid.getNomeCidade());
            ps.setInt(2, cid.getIdEstadoCidade());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao salvar cidade:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

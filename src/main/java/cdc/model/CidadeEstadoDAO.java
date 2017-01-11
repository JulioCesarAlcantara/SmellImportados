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
 * @author cesar
 */
public class CidadeEstadoDAO implements DAO {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List buscaEstados() throws Exception {
        PreparedStatement ps = null;

        Connection conn = ConnectionDAO.getConnection();

        ArrayList estados = new ArrayList();

        try {
            String sql = "SELECT estadoSigla AS Sigla FROM Estado";
            // ResultSet rs = ps.executeQuery();
            ps = conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) ps;

            int i = 1;
            while (rs.next()) {
                estados.add(rs.getString(i));
                i++;
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Estados: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

        return estados;

    }

}

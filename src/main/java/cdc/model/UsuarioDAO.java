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
public class UsuarioDAO implements DAO {

    Connection conn;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Usuario com = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update Usuario set nomeUsuario = ?, telefone1Usuario = ?, telefone2Usuario = ?, emailUsuario=?, tipoUsuario=?, dataNascimentoUsuario=?, sexoUsuario=?, passwordUsuario=? where idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeUsuario());
            ps.setString(2, com.getTelefone1Usuario());
            ps.setString(3, com.getTelefone2Usuario());
            ps.setString(4, com.getEmailUsuario());
            ps.setString(5, com.getTipoUsuario());
            ps.setDate(6, com.getDataNascimentoUsuario());
            ps.setString(7, com.getSexoUsuario());
            ps.setString(8, com.getPasswordUsuario());
            ps.setInt(9, com.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Usuario com = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Usuario where idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdUsuario());
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
            ps = conn.prepareStatement("select * from Usuario where tipoUsuario <> 'c'");
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
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
        Usuario com = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Usuario ";
            String where = "";
            boolean checa = false;
            if (com.getIdUsuario() != 0) {
                where = "where ";
                if (com.getIdUsuario() != 0) {
                    where += "idUsuario=? ";
                    checa = true;
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (com.getIdUsuario() != 0) {
                if (com.getIdUsuario() != 0) {
                    ps.setInt(contaCampos, com.getIdUsuario());
                    contaCampos++;
                }
            }
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
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
        Usuario com = (Usuario) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "insert into Usuario (nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, tipoUsuario, dataNascimentoUsuario, sexoUsuario, passwordUsuario) values (?,?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeUsuario());
            ps.setString(2, com.getTelefone1Usuario());
            ps.setString(3, com.getTelefone2Usuario());
            ps.setString(4, com.getEmailUsuario());
            ps.setString(5, com.getTipoUsuario());
            ps.setDate(6, com.getDataNascimentoUsuario());
            ps.setString(7, com.getSexoUsuario());
            ps.setString(8, com.getPasswordUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public boolean verificaLogin(String email, String senha) throws Exception {
        String username = email;
        String password = senha;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT tipoUsuario FROM Usuario WHERE emailUsuario = ? AND passwordUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();

            return size >= 1;

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

}

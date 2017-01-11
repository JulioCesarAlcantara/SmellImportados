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
public class UsuarioDAO  implements DAO {

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
            String sql = "update Usuario set nomeUsuario = ?, telefone1Usuario = ?, telefone2Usuario = ?, emailUsuario=?, tipoUsuario=?, idClienteUsuario = ? where idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeUsuario());
            ps.setString(2, com.getTelefone1Usuario());
            ps.setString(3, com.getTelefone2Usuario());
            ps.setString(4, com.getEmailUsuario());
            ps.setString(5, com.getTipoUsuario());
            ps.setInt(6, com.getIdClienteUsuario());
            ps.setInt(7, com.getIdUsuario());

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
            ps = conn.prepareStatement("select * from Usuario");
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
              //  list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
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
            if (com.getIdUsuario() != 0 || com.getNomeUsuario() != null || com.getTipoUsuario() != null || com.getIdClienteUsuario() != 0) {
                where = "where ";
                if (com.getIdUsuario() != 0) {
                    where += "idUsuario=? ";
                    checa = true;
                }
                if (com.getNomeUsuario() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " nommeUsuario=? ";
                    checa = true;
                }
                if (com.getTipoUsuario() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " tipoUsuario=? ";
                    checa = true;
                }
                if (com.getIdClienteUsuario() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " idClienteUsuario=? ";
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (com.getIdUsuario() != 0 || com.getNomeUsuario() != null || com.getTipoUsuario() != null || com.getIdClienteUsuario() != 0) {
                if (com.getIdUsuario() != 0) {
                    ps.setInt(contaCampos, com.getIdUsuario());
                    contaCampos++;
                }
                if (com.getNomeUsuario() != null) {
                    ps.setString(contaCampos, com.getNomeUsuario());
                    contaCampos++;
                }
                if (com.getTipoUsuario() != null) {
                    ps.setString(contaCampos, com.getTipoUsuario());
                }
                if(com.getIdClienteUsuario() != 0){
                    ps.setInt(contaCampos, com.getIdClienteUsuario());
                }
            }
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                Integer idUsuario = rs.getInt(1);
                String nomeUsuario = rs.getString(2);
                String telefone1 = rs.getString(3);
                String telefone2 = rs.getString(4);
                String email = rs.getString(5);
                String tipoUsuario = rs.getString(6);
                Integer idClienteUsuario = rs.getInt(7);
                //list.add(new Usuario(idUsuario, nomeUsuario, telefone1, telefone2, email, tipoUsuario, idClienteUsuario));
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
            String sql = "insert into Usuario (nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, tipoUsuario, dataNascimentoUsuario, sexoUsuario) values (?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, com.getNomeUsuario());
            ps.setString(2, com.getTelefone1Usuario());
            ps.setString(3, com.getTelefone2Usuario());
            ps.setString(4, com.getEmailUsuario());
            ps.setString(5, com.getTipoUsuario());
            ps.setDate(6, com.getDataNascimentoUsuario());
            ps.setString(7, com.getSexoUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

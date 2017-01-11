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
public class LoginDAO implements DAO {

    Connection conn;

    public LoginDAO() {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Login lgn = (Login) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (lgn == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update Login set userNameLogin = ?, passwordLogin = ? where idLogin = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, lgn.getUsernameLogin());
            ps.setString(2, lgn.getPasswordLogin());
            ps.setInt(3, lgn.getIdLogin());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Login lgn = (Login) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (lgn == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Login where idLogin = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lgn.getIdLogin());
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
            ps = conn.prepareStatement("select * from Login");
            rs = ps.executeQuery();
            List<Login> list = new ArrayList<Login>();
            while (rs.next()) {
                list.add(new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
        Login lgn = (Login) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (lgn == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Login ";
            String where = "";
            boolean checa = false;
            if (lgn.getIdLogin() != 0 || lgn.getUsernameLogin() != null || lgn.getPasswordLogin() != null || lgn.getIdUsuarioLogin() != 0) {
                where = "where ";
                if (lgn.getIdLogin() != 0) {
                    where += "idLogin=? ";
                    checa = true;
                }
                if (lgn.getUsernameLogin() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " usernameLogin=? ";
                    checa = true;
                }
                if (lgn.getPasswordLogin() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " passwordLogin";
                }
                if (lgn.getIdUsuarioLogin() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " idUsuarioLogin=? ";
                }

            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (lgn.getIdLogin() != 0 || lgn.getUsernameLogin() != null || lgn.getPasswordLogin() != null || lgn.getIdUsuarioLogin() != 0) {
                if (lgn.getIdLogin() != 0) {
                    ps.setInt(contaCampos, lgn.getIdLogin());
                    contaCampos++;
                }
                if (lgn.getUsernameLogin() != null) {
                    ps.setString(contaCampos, lgn.getUsernameLogin());
                    contaCampos++;
                }
                if (lgn.getPasswordLogin() != null) {
                    ps.setString(contaCampos, lgn.getPasswordLogin());
                    contaCampos++;
                }
                if (lgn.getIdUsuarioLogin() != 0) {
                    ps.setInt(contaCampos, lgn.getIdUsuarioLogin());
                }
            }
            rs = ps.executeQuery();
            List<Login> list = new ArrayList<Login>();
            while (rs.next()) {
                Integer idLogin = rs.getInt(1);
                String usernameLogin = rs.getString(2);
                String passwordLogin = rs.getString(3);
                Integer idUsuarioLogin = rs.getInt(4);
                list.add(new Login(idLogin, usernameLogin, passwordLogin, idUsuarioLogin));
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
        Login lgn = (Login) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (lgn == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String sql = "insert into Login (usernameLogin, passwordLogin, idUsuarioLogin) values (?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, lgn.getUsernameLogin());
            ps.setString(2, lgn.getPasswordLogin());
            ps.setInt(3, lgn.getIdUsuarioLogin());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
}

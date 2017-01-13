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
public class EstadoDAO implements DAO {

    Connection conn;

    public EstadoDAO() {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Estado uf = (Estado) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (uf == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update Estado set estadoNome = ?, estadoSigla = ? where idEstado = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, uf.getEstadoNome());
            ps.setString(2, uf.getEstadoSigla());
            ps.setInt(3, uf.getIdEstado());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Estado uf = (Estado) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (uf == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Estado where idEstado = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uf.getIdEstado());
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
            ps = conn.prepareStatement("select * from Estado");
            rs = ps.executeQuery();
            List<Estado> list = new ArrayList<Estado>();
            while (rs.next()) {
                list.add(new Estado(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
        Estado uf = (Estado) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (uf == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Estado ";
            String where = "";
            boolean checa = false;
            if (uf.getIdEstado() != 0 || uf.getEstadoNome() != null || uf.getEstadoSigla() != null) {
                where = "where ";
                if (uf.getIdEstado() != 0) {
                    where += "idEstado=? ";
                    checa = true;
                }
                if (uf.getEstadoNome() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " estadoNome=? ";
                    checa = true;
                }
                if (uf.getEstadoSigla() != null) {
                    if (checa) {
                        where += "and";
                    }
                    where += " estadoSigla=? ";
                }

            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (uf.getIdEstado() != 0 || uf.getEstadoNome() != null || uf.getEstadoSigla() != null) {
                if (uf.getIdEstado() != 0) {
                    ps.setInt(contaCampos, uf.getIdEstado());
                    contaCampos++;
                }
                if (uf.getEstadoNome() != null) {
                    ps.setString(contaCampos, uf.getEstadoNome());
                    contaCampos++;
                }
                if (uf.getEstadoSigla() != null) {
                    ps.setString(contaCampos, uf.getEstadoSigla());
                }
            }
            rs = ps.executeQuery();
            List<Estado> list = new ArrayList<Estado>();
            while (rs.next()) {
                Integer idEstado = rs.getInt(1);
                String estadoNome = rs.getString(2);
                String estadoSigla = rs.getString(3);
                list.add(new Estado(idEstado, estadoNome, estadoSigla));
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
        Estado uf = (Estado) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (uf == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String sql = "insert into Estado (estadoNome, estadoSigla) values (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, uf.getEstadoNome());
            ps.setString(2, uf.getEstadoSigla());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
    
    public List<Estado> teste() throws Exception {
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection();
        
        List<Estado> estado = new ArrayList<>();
        String query = "SELECT * FROM Estado";
        
        ps = conn.prepareStatement(query);
        ResultSet rs = (ResultSet) ps;

        while(rs.next()){
            Estado a = new Estado(); 
            a.setIdEstado(rs.getInt(1));
            a.setEstadoNome(rs.getString(2));
            a.setEstadoSigla(rs.getString(3));
            
            estado.add(a); 
        }
        
        return estado; 
        
    }
    
}

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
public class CompraDAO implements DAO {

    Connection conn;

    public CompraDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Compra com = (Compra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update Compra set valorCompra = ?, freteCompra = ?, idClienteCompra = ? where idCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, com.getPrecoCompra());
            ps.setFloat(2, com.getFreteCompra());
            ps.setInt(3, com.getIdUsuarioCompra());
            ps.setInt(4, com.getIdCompra());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Compra com = (Compra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Compra where idCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdCompra());
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
            ps = conn.prepareStatement("select * from Compra");
            rs = ps.executeQuery();
            List<Compra> list = new ArrayList<Compra>();
            while (rs.next()) {
                list.add(new Compra(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4)));
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
        Compra com = (Compra) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Compra ";
            String where = "";
            boolean checa = false;
            if (com.getIdCompra() != 0 || com.getFreteCompra() != 0 || com.getPrecoCompra() != 0 || com.getIdUsuarioCompra() != 0) {
                where = "where ";
                if (com.getIdCompra() != 0) {
                    where += "idCompra=? ";
                    checa = true;
                }
                if (com.getFreteCompra() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " freteCompra=? ";
                    checa = true;
                }
                if (com.getPrecoCompra() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " precoCompra=? ";
                    checa = true;
                }
                if (com.getIdUsuarioCompra() != 0) {
                    if (checa) {
                        where += "and";
                    }
                    where += " idClienteCompra=? ";
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (com.getIdCompra() != 0 || com.getFreteCompra() != 0 || com.getPrecoCompra() != 0 || com.getIdUsuarioCompra() != 0) {
                if (com.getIdCompra() != 0) {
                    ps.setInt(contaCampos, com.getIdCompra());
                    contaCampos++;
                }
                if (com.getPrecoCompra() != 0) {
                    ps.setFloat(contaCampos, com.getPrecoCompra());
                    contaCampos++;
                }
                if (com.getFreteCompra() != 0) {
                    ps.setFloat(contaCampos, com.getFreteCompra());
                }
                if(com.getIdUsuarioCompra() != 0){
                    ps.setInt(contaCampos, com.getIdUsuarioCompra());
                }
            }
            rs = ps.executeQuery();
            List<Compra> list = new ArrayList<Compra>();
            while (rs.next()) {
                Integer idCompra = rs.getInt(1);
                Float freteCompra = rs.getFloat(2);
                Float precoCompra = rs.getFloat(3);
                Integer idClienteCompra = rs.getInt(4);
                list.add(new Compra(idCompra, precoCompra, freteCompra, idClienteCompra));
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
        Compra com = (Compra) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "insert into Compra (valorCompra, freteCompra, idUsuarioCompra) values (?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, com.getPrecoCompra());
            ps.setFloat(2, com.getFreteCompra());
            ps.setInt(3, com.getIdUsuarioCompra());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

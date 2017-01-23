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
public class ItemCompraDAO implements DAO {

    Connection conn;

    public ItemCompraDAO() {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        ItemCompra ic = (ItemCompra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update ItemCompra set idCompraItemCompra = ?, idProdutoItemCompra = ? where idItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdCompraItemCompra());
            ps.setInt(2, ic.getIdProdutoItemCompra());
            ps.setInt(3, ic.getIdItemCompra());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        ItemCompra ic = (ItemCompra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from ItemCompra where idItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdItemCompra());
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
            ps = conn.prepareStatement("select * from ItemCompra");
            rs = ps.executeQuery();
            List<ItemCompra> list = new ArrayList<ItemCompra>();
            while (rs.next()) {
                list.add(new ItemCompra(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
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
        ItemCompra ic = (ItemCompra) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from ItemCompra ";
            String where = "";
            boolean checa = false;
            if (ic.getIdItemCompra() != 0) {
                where = "where ";
                if (ic.getIdItemCompra() != 0) {
                    where += "idItemCompra=? ";
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (ic.getIdItemCompra() != 0) {
                if (ic.getIdItemCompra() != 0) {
                    ps.setInt(contaCampos, ic.getIdItemCompra());
                    contaCampos++;
                }

            }
            rs = ps.executeQuery();
            List<ItemCompra> list = new ArrayList<ItemCompra>();
            while (rs.next()) {
                Integer idItemCompra = rs.getInt(1);
                Integer idCompraItemCompra = rs.getInt(2);
                Integer idProdutoItemCompra = rs.getInt(3);
                list.add(new ItemCompra(idItemCompra, idCompraItemCompra, idProdutoItemCompra));
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
        ItemCompra ic = (ItemCompra) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String sql = "insert into ItemCompra (idCompraItemCompra, idProdutoItemCompra) values (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdCompraItemCompra());
            ps.setInt(2, ic.getIdProdutoItemCompra());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluirPromo(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new Exception("O valor passado não pode ser nulo!");
        }

        try {
            String sql = "delete from ItemCompra where idProdutoItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println(ps);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

}

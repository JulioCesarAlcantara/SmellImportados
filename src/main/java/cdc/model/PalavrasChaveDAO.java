package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cesar
 */
public class PalavrasChaveDAO implements DAO {

    private Connection conn;

    public PalavrasChaveDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection(); 
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        }
    }
    
    

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
        PalavrasChave pc = (PalavrasChave) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (pc == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "INSERT INTO PalavrasChave (palavra1, palavra2, palavra3, idProduto) VALUES (?,?,?,?)";
            conn = this.conn;
            System.out.println("1");
            ps = conn.prepareStatement(sql);
            System.out.println("2");
            ps.setString(1, pc.getPalavra1());
            ps.setString(2, pc.getPalavra2());
            ps.setString(3, pc.getPalavra3());
            ps.setInt(4, pc.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

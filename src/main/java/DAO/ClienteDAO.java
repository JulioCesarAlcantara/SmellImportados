package DAO;

import Conexao.ConnectionDAO;
import Conexao.DAO;
import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ClienteDAO implements DAO {

    private Connection conn = null; 

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
    public void cadastra(Object ob) throws Exception {
        ClienteModel cli;
        cli = (ClienteModel) ob;
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection(); 

        if (cli == null) {
            throw new Exception("O valor designado para o cliente não pode ser nulo. Por favor informe valores.");
        }

        try {
            String query = "INSERT INTO Cliente (idCliente, nomeCliente, sexoCliente, cpfCliente, telefone1Cliente, telefone2Cliente, emailcliente, cepCliente, idCidadeCliente) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);

            ps.setInt(1, cli.getIdCliente());
            ps.setString(2, cli.getNomeCliente());
            ps.setString(3, cli.getSexoCliente());
            ps.setString(4, cli.getCpfCliente());
            ps.setString(5, cli.getTelefone1Cliente());
            ps.setString(6, cli.getTelefone2Cliente());
            ps.setString(7, cli.getEmailCliente());
            ps.setString(8, cli.getCepCliente());
            ps.setInt(9, cli.getIdCidadeCliente());

            System.out.println("aqui 2");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

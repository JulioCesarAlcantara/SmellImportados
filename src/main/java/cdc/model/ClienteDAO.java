package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
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
    public void salvar(Object ob) throws Exception {
        ClienteModel cli;
        cli = (ClienteModel) ob;
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection();

        if (cli == null) {
            throw new Exception("O valor designado para o cliente não pode ser nulo. Por favor informe valores.");
        }

        try {
            String query = "insert into Usuario (nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, "
                    + "tipoUsuario, dataNascimentoUsuario, sexoUsuario, "
                    + "cpfUsuario, enderecoUsuario, cepUsuario) values (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, cli.getNomeCliente());
            ps.setString(2, cli.getTelefone1Cliente());
            ps.setString(3, cli.getTelefone2Cliente());
            ps.setString(4, cli.getEmailCliente());
            ps.setString(5, "c");
            ps.setDate(6, cli.getDataNascimentoCliente());
            ps.setString(7, cli.getSexoCliente());
            ps.setString(8, cli.getCpfCliente());
            ps.setString(9, cli.getEnderecoCliente());
            ps.setString(10, cli.getCepCliente());
            System.out.println(ps);
            System.out.println("aqui 2");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

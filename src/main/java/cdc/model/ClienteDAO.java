package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import Model.ClienteModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ClienteDAO implements DAO {

    private Connection conn = null;

    public ClienteDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        ClienteModel cli;
        cli = (ClienteModel) ob;
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection();

        if (cli == null) {
            throw new Exception("O valor designado para o cliente não pode ser nulo. Por favor informe valores.");
        }

        try {
            String query = "UPDATE Usuario set nomeUsuario=?, telefone1Usuario=?, telefone2Usuario=?, emailUsuario=?, "
                    + "tipoUsuario=?, dataNascimentoUsuario=?, sexoUsuario=?, "
                    + "cpfUsuario=?, enderecoUsuario=?, cepUsuario=?, passwordUsuario=?, cidadeUsuario=?, estadoUsuario=? WHERE idUsuario = ?";
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
            ps.setString(11, cli.getPasswordCliente());
            ps.setString(12, cli.getCidadeCliente());
            ps.setString(13, cli.getEstadoCliente());
            ps.setInt(14, cli.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ClienteModel cli = (ClienteModel) ob;

        if (cli == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "delete from Usuario where idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cli.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
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
            ps = conn.prepareStatement("select * from Usuario where tipoUsuario = 'c'");
            rs = ps.executeQuery();
            List<ClienteModel> list = new ArrayList<ClienteModel>();
            while (rs.next()) {
                Integer idCliente = rs.getInt(1);
                String nomeCliente = rs.getString(2);
                String telefone1 = rs.getString(3);
                String telefone2 = rs.getString(4);
                String email = rs.getString(5);
                String tipo = rs.getString(6);
                Date dataNascimento = rs.getDate(7);
                String sexo = rs.getString(8);
                String password = rs.getString(9);
                String cpf = rs.getString(10);
                String endereco = rs.getString(11);
                String cep = rs.getString(12);
                String cidade = rs.getString(13);
                String estado = rs.getString(14);
                list.add(new ClienteModel(idCliente, nomeCliente, telefone1, telefone2, email, tipo, dataNascimento, sexo, cpf, endereco, cep, password, cidade, estado));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        ClienteModel aut = (ClienteModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (aut == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select idUsuario, nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, tipoUsuario, dataNascimentoUsuario, sexoUsuario, passwordUsuario, cpfUsuario, enderecoUsuario, cepUsuario, cidadeUsuario, estadoUsuario from Usuario ";
            String where = "";
            boolean checa = false;
            if (aut.getIdCliente() != 0) {
                where = "where ";
                if (aut.getIdCliente() != 0) {
                    where += "idUsuario=? ";
                    checa = true;
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (aut.getIdCliente() != 0) {
                if (aut.getIdCliente() != 0) {
                    ps.setInt(contaCampos, aut.getIdCliente());
                    contaCampos++;
                }
            }
            rs = ps.executeQuery();
            List<ClienteModel> list = new ArrayList<ClienteModel>();
            while (rs.next()) {
                Integer idCliente = rs.getInt(1);
                String nomeCliente = rs.getString(2);
                String telefone1 = rs.getString(3);
                String telefone2 = rs.getString(4);
                String email = rs.getString(5);
                String tipo = rs.getString(6);
                Date dataNascimento = rs.getDate(7);
                String sexo = rs.getString(8);
                String password = rs.getString(9);
                String cpf = rs.getString(10);
                String endereco = rs.getString(11);
                String cep = rs.getString(12);
                String cidade = rs.getString(13);
                String estado = rs.getString(14);
                list.add(new ClienteModel(idCliente, nomeCliente, telefone1, telefone2, email, tipo, dataNascimento, sexo, cpf, endereco, cep, password, cidade, estado));
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
                    + "cpfUsuario, enderecoUsuario, cepUsuario, passwordUsuario, cidadeUsuario, estadoUsuario) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(11, cli.getPasswordCliente());
            ps.setString(12, cli.getCidadeCliente());
            ps.setString(13, cli.getEstadoCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}

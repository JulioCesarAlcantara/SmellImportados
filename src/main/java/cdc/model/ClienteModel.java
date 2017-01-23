package Model;

import java.sql.Date;

/**
 *
 * @author cesar
 */
public class ClienteModel {

    Integer idCliente;
    String nomeCliente;
    String telefone1Cliente;
    String telefone2Cliente;
    String emailCliente;
    String tipoCliente;
    Date dataNascimentoCliente;
    String sexoCliente;
    String cpfCliente;
    String enderecoCliente;
    String cepCliente;
    String passwordCliente;
    String cidadeCliente;
    String estadoCliente;

    public ClienteModel() {
    }

    public ClienteModel(Integer id) {
        this.idCliente = id;
    }

    public ClienteModel(String nomeCliente, String telefone1Cliente, String telefone2Cliente, String emailCliente, String tipoCliente, Date dataNascimentoCliente, String sexoCliente, String cpfCliente, String enderecoCliente, String cepCliente, String passwordCliente, String cidadeCliente, String estadoCliente) {
        this.nomeCliente = nomeCliente;
        this.telefone1Cliente = telefone1Cliente;
        this.telefone2Cliente = telefone2Cliente;
        this.emailCliente = emailCliente;
        this.tipoCliente = tipoCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.sexoCliente = sexoCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.cepCliente = cepCliente;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
        this.passwordCliente = passwordCliente;
    }

    public ClienteModel(int idCliente, String nomeCliente, String telefone1Cliente, String telefone2Cliente, String emailCliente, String tipoCliente, Date dataNascimentoCliente, String sexoCliente, String cpfCliente, String enderecoCliente, String cepCliente, String passwordCliente, String cidadeCliente, String estadoCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefone1Cliente = telefone1Cliente;
        this.telefone2Cliente = telefone2Cliente;
        this.emailCliente = emailCliente;
        this.tipoCliente = tipoCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.sexoCliente = sexoCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.cepCliente = cepCliente;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
        this.passwordCliente = passwordCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone1Cliente() {
        return telefone1Cliente;
    }

    public void setTelefone1Cliente(String telefone1Cliente) {
        this.telefone1Cliente = telefone1Cliente;
    }

    public String getTelefone2Cliente() {
        return telefone2Cliente;
    }

    public void setTelefone2Cliente(String telefone2Cliente) {
        this.telefone2Cliente = telefone2Cliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Date dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

}

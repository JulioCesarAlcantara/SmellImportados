package Model;

/**
 *
 * @author cesar
 */
public class ClienteModel {
    Integer idCliente; 
    Integer idCidadeCliente; 
    String nomeCliente; 
    String sexoCliente;
    String cpfCliente;
    String telefone1Cliente;
    String telefone2Cliente;
    String emailCliente; 
    String endereçocliente; 
    String cepCliente; 

    public ClienteModel() {
    }

    public ClienteModel(String nomeCliente, String sexoCliente, String cpfCliente, String telefone1Cliente, String telefone2Cliente, String emailCliente, String endereçocliente, String cepCliente) {
        this.nomeCliente = nomeCliente;
        this.sexoCliente = sexoCliente;
        this.cpfCliente = cpfCliente;
        this.telefone1Cliente = telefone1Cliente;
        this.telefone2Cliente = telefone2Cliente;
        this.emailCliente = emailCliente;
        this.endereçocliente = endereçocliente;
        this.cepCliente = cepCliente;
    }

    public ClienteModel(int i, String nomeCliente, String sexoCliente, String cpfCliente, String telefone1Cliente, String telefone2Cliente, String emailCliente, String cepCliente, int i0) {
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCidadeCliente() {
        return idCidadeCliente;
    }

    public void setIdCidadeCliente(int idCidadeCliente) {
        this.idCidadeCliente = idCidadeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getEndereçocliente() {
        return endereçocliente;
    }

    public void setEndereçocliente(String endereçocliente) {
        this.endereçocliente = endereçocliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    
    
}

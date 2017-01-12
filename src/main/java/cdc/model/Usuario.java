package cdc.model;

import java.sql.Date;

/**
 *
 * @author erik
 */
public class Usuario {
    
    private int idUsuario;
    private String nomeUsuario;
    private String telefone1Usuario;
    private String telefone2Usuario;
    private String emailUsuario;
    private String tipoUsuario;
    private Date dataNascimentoUsuario;
    private String sexoUsuario;
    private String passwordUsuario;
    private int idClienteUsuario;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String telefone1Usuario, String telefone2Usuario, String emailUsuario, String tipoUsuario, Date dataNascimentoUsuario, String sexoUsuario, String passwordUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.telefone1Usuario = telefone1Usuario;
        this.telefone2Usuario = telefone2Usuario;
        this.emailUsuario = emailUsuario;
        this.tipoUsuario = tipoUsuario;
        this.dataNascimentoUsuario = dataNascimentoUsuario;
        this.sexoUsuario = sexoUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    
    public Usuario(int idUsuario, String nomeUsuario, String telefone1Usuario, String telefone2Usuario, String emailUsuario, String tipoUsuario, Date dataNascimentoUsuario, String sexoUsuario, String passwordUsuario, int idClienteUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.telefone1Usuario = telefone1Usuario;
        this.telefone2Usuario = telefone2Usuario;
        this.emailUsuario = emailUsuario;
        this.tipoUsuario = tipoUsuario;
        this.dataNascimentoUsuario = dataNascimentoUsuario;
        this.sexoUsuario = sexoUsuario;
        this.passwordUsuario = passwordUsuario;
        this.idClienteUsuario = idClienteUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefone1Usuario() {
        return telefone1Usuario;
    }

    public void setTelefone1Usuario(String telefone1Usuario) {
        this.telefone1Usuario = telefone1Usuario;
    }

    public String getTelefone2Usuario() {
        return telefone2Usuario;
    }

    public void setTelefone2Usuario(String telefone2Usuario) {
        this.telefone2Usuario = telefone2Usuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(Date dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public int getIdClienteUsuario() {
        return idClienteUsuario;
    }

    public void setIdClienteUsuario(int idClienteUsuario) {
        this.idClienteUsuario = idClienteUsuario;
    }
    
    
    
}

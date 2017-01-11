package cdc.model;

/**
 *
 * @author erik
 */
public class Login {
    
    private int idLogin;
    private String usernameLogin;
    private String passwordLogin;
    private int idUsuarioLogin;

    public Login() {
    }

    public Login(int idLogin, String usernameLogin, String passwordLogin, int idUsuarioLogin) {
        this.idLogin = idLogin;
        this.usernameLogin = usernameLogin;
        this.passwordLogin = passwordLogin;
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public Login(String usernameLogin, String passwordLogin) {
        this.usernameLogin = usernameLogin;
        this.passwordLogin = passwordLogin;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public int getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    
    
}

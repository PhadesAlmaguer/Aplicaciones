package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by palmaguer on 6/12/16.
 */
public class Adapter_Usuario {
    private String username;
    private String password;

    private static Adapter_Usuario USUARIO;

    public Adapter_Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Adapter_Usuario() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Adapter_Usuario checkSingleton()
    {
        if (USUARIO == null)  {
            USUARIO = new Adapter_Usuario();
        }
        return USUARIO;
    }
}

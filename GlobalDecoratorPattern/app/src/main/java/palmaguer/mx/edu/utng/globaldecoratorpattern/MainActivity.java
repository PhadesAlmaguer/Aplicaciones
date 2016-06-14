package palmaguer.mx.edu.utng.globaldecoratorpattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private SharedPreferences shared;
    private static final int PREFERENCE_MODE_PRIVATE = 0;

    String phades = "phades", pass = "Ios";

    private String usuario = "phadesalmaguer", contrasenia = "dos";

    public Button btnEntrar;
    public EditText edtUsuario, edtContrasenia;

    public Adapter_Usuario user;
    Singleton singleton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        crearElementos();
    }

    void crearElementos(){
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        edtContrasenia = (EditText)findViewById(R.id.edtContrasenia);
        edtUsuario = (EditText)findViewById(R.id.edtUsuario);

        edtContrasenia.setText("dos");
        edtUsuario.setText("phadesalmaguer");

        btnEntrar.setOnClickListener(this);
        /*
        shared = getPreferences(PREFERENCE_MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = shared.edit();
        sharedEditor.putString("phades",phades);
        sharedEditor.putString("pass",pass);}
        */
        //user = new Adapter_Usuario(shared.getString("Phades",phades),shared.getString("Ios",pass));
        user = new Adapter_Usuario();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == btnEntrar.getId()){

            user.setUsername(edtUsuario.getText().toString());
            user.setPassword(edtContrasenia.getText().toString());

            singleton  = Singleton.getInstance();
            Toast.makeText(this, "Singleton: "+singleton.toString(), Toast.LENGTH_SHORT).show();

            if ( verifiUser()== true ){
                //if ( edtContrasenia.getText().toString().equals( shared.getString("Ios",pass) ) && edtUsuario.getText().toString().equals(shared.getString("phades",phades)) ){
                // Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(this, MenuPrincipal.class);
                startActivity(intent);
                //setContentView(R.layout.menu_principal);
            }
            else {
                Toast.makeText(this, "Datos incorrectos, verificalos por favor.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    /*
    void putShared(){
        shared = getPreferences(PREFERENCE_MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = shared.edit();

        sharedEditor.putString("phades",phades);
        sharedEditor.putString("pass",pass);
        sharedEditor.commit();
    }
    */

    boolean verifiUser(){

        if ( user.getUsername().toString().equals(usuario) && user.getPassword().toString().equals(contrasenia) ){
            return true;
        }
        else {
            Toast.makeText(this, "Usuario o contraseña incorrectos, verifique sus datos.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

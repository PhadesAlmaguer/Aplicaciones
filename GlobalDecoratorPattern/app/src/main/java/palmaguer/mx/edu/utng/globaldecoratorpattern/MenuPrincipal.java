package palmaguer.mx.edu.utng.globaldecoratorpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Phades Almaguer on 13/05/2016.
 */
public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    Button btnDecotaror, btnAdapter, btnCommand;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        crearElementos2();
    }

    public void crearElementos2(){
        btnAdapter = (Button)findViewById(R.id.btnAdapter);
        btnDecotaror = (Button)findViewById(R.id.btnDecoratorPattern);
        //btnCommand = (Button)findViewById(R.id.btnCommand);

        btnAdapter.setOnClickListener(this);
        btnDecotaror.setOnClickListener(this);
        //btnCommand.setOnClickListener(this);
        intent = new Intent();

    }
    public void onBackPressed(){
        moveTaskToBack(false);
    }

    @Override
    public void onClick(View v) {

         /*if (v.getId() == btnCommand.getId()){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            finish();
            System.exit(0);

            Toast.makeText(this, "comand", Toast.LENGTH_SHORT).show();
            intent.setClass(this, CommandPattern.class);
            startActivity(intent);
            setContentView(R.layout.menu_principal);
        }*/

        if (v.getId() == btnDecotaror.getId()){
           Toast.makeText(this, "decorator", Toast.LENGTH_SHORT).show();
            intent.setClass(this, DecoratorPattern.class);
            startActivity(intent);
        }
        if (v.getId() == btnAdapter.getId()){
           Toast.makeText(this, "adapter", Toast.LENGTH_SHORT).show();
            intent.setClass(this, AdapterTest.class);
            startActivity(intent);
        }

    }
}

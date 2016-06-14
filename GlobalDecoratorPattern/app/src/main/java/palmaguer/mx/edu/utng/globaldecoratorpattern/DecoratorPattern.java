package palmaguer.mx.edu.utng.globaldecoratorpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Phades Almaguer on 13/05/2016.
 */
public class DecoratorPattern extends AppCompatActivity implements View.OnClickListener  {

    public TextView txtNombre, txtTotalCompra;
    public Button btnAddNueces, btnAddMiel,btnCancelarCompra, btnRealizarCompra, btnHeladoSencillo;

    ConoDeVieveBasico conoDeVieveBasico;
    NuecesDecorator nuecesDecorator;
    MielDocorator mielDocorator;
    double previoGlobal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.decorator_pattern);
        crearInterfaz();

    }

    void crearInterfaz(){
        btnAddNueces = (Button)findViewById(R.id.btnNueces);
        btnAddMiel = (Button)findViewById(R.id.btnMiel);
        btnHeladoSencillo = (Button)findViewById(R.id.btnHeladoSencillo);
        btnCancelarCompra = (Button)findViewById(R.id.btnCancelarCompra);
        btnRealizarCompra = (Button)findViewById(R.id.btnRelizarCompra);

        btnAddNueces.setOnClickListener(this);
        btnAddMiel.setOnClickListener(this);
        btnHeladoSencillo.setOnClickListener(this);
        btnRealizarCompra.setOnClickListener(this);
        btnCancelarCompra.setOnClickListener(this);

        txtTotalCompra = (TextView)findViewById(R.id.txtTotalCompra);
        txtTotalCompra.setText("0.0");

        btnAddNueces.setClickable(false);
        btnAddMiel.setClickable(false);
    }

    public void disableButtons(){
        btnAddNueces.setClickable(false);
        btnAddMiel.setClickable(false);
        btnHeladoSencillo.setClickable(false);
    }
    public void enableButtons(){
        btnAddNueces.setClickable(true);
        btnAddMiel.setClickable(true);
        btnHeladoSencillo.setClickable(true);
    }

    public void nullObjects(){
        if (conoDeVieveBasico != null){
            conoDeVieveBasico = null;
        }
        if(mielDocorator != null){
            mielDocorator = null;
        }
        if(nuecesDecorator != null){
            nuecesDecorator = null;
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == btnCancelarCompra.getId()){

            enableButtons();
            nullObjects();
            txtTotalCompra.setText("");
        }
        if (v.getId() == btnAddMiel.getId()){
            //txtTotalCompra.setText("");
            //disableButtons();
            mielDocorator = new MielDocorator(new ConoDeVieveBasico());
            //mielDocorator.agregarMiel();
            mielDocorator.agregarMiel();
            mielDocorator.setPrecio(15);
            //txtTotalCompra.setText(""+mielDocorator.getPrecio());
        }
        if (v.getId() == btnAddNueces.getId()){
            txtTotalCompra.setText("");
            //disableButtons();
            nuecesDecorator = new NuecesDecorator(new ConoDeVieveBasico());
            nuecesDecorator.agregarNueces();
            nuecesDecorator.setPrecio(5);

        }
        if (v.getId() == btnRealizarCompra.getId()){
            if(!btnAddMiel.isClickable()){
                txtTotalCompra.setText(conoDeVieveBasico.hacerHelado());
                conoDeVieveBasico = null;
            }
            if (nuecesDecorator != null){
                nuecesDecorator.hacerHelado();
                nuecesDecorator = null;
            }
            if (mielDocorator != null){
                txtTotalCompra.setText(mielDocorator.hacerHelado());

                //txtTotalCompra.setText(""+previoGlobal);
                mielDocorator = null;
            }
        }
        if (v.getId() == btnHeladoSencillo.getId()){
            txtTotalCompra.setText("");
            //disableButtons();
            conoDeVieveBasico = new ConoDeVieveBasico();
            Toast.makeText(this, conoDeVieveBasico.hacerHelado()+"", Toast.LENGTH_SHORT).show();

        }
    }
}

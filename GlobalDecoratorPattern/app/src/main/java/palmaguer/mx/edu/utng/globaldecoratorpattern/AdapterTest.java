package palmaguer.mx.edu.utng.globaldecoratorpattern;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AdapterTest extends AppCompatActivity implements View.OnClickListener {

    ToggleButton tggFormat;
    EditText edtFormat, edtFile;
    Button btnReproducir;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_pattern);
        crearElementos();

    }

    void crearElementos(){
        tggFormat = (ToggleButton)findViewById(R.id.tggformato);
        edtFile = (EditText)findViewById(R.id.edtname);
        edtFormat = (EditText)findViewById(R.id.edtformat);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        imagen = (ImageView)findViewById(R.id.imgDisc);
        btnReproducir.setOnClickListener(this);
        tggFormat.setOnClickListener(this);
        tggFormat.setChecked(true);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == btnReproducir.getId()){
            //Toast.makeText(this, "repro", Toast.LENGTH_SHORT).show();
            Adapter_AudioPlayer audioPlayer = new Adapter_AudioPlayer();
            if ( camposNulos() == false ){
                if (formatoValido()){
                    if( tggFormat.isChecked() ){
                        audioPlayer.play(edtFormat.getText().toString(), edtFile.getText().toString());
                        Toast.makeText(this, "Reproduciendo audio: "+edtFile.getText().toString()+"."+edtFormat.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        audioPlayer.play(edtFormat.getText().toString(), edtFile.getText().toString());
                        Toast.makeText(this, "Mostrando: "+edtFile.getText().toString()+"."+edtFormat.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        if (v.getId() == tggFormat.getId()){
            if (tggFormat.isChecked()){
                imagen.setImageResource(R.drawable.audio);
                edtFormat.setText("");
            }else{
                edtFormat.setText("");
                imagen.setImageResource(R.drawable.video);
            }
        }
    }

    public boolean camposNulos(){
        if ( !edtFormat.getText().toString().equals("") && !edtFile.getText().toString().equals("") ){
            return false;
        }
        else {
            Toast.makeText(this, "Complete el formulario.", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean formatoValido(){
        if ( edtFormat.getText().toString().equals("mp3") || edtFormat.getText().toString().equals("mp4") ||
                edtFormat.getText().toString().equals("avi") || edtFormat.getText().toString().equals("vlc")  ){
            return true;
        }
        else{
            Toast.makeText(this, "Formato desconocido.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

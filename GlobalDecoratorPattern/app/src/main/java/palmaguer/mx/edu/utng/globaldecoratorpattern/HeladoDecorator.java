package palmaguer.mx.edu.utng.globaldecoratorpattern;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Phades Almaguer on 12/05/2016.
 */
public class HeladoDecorator implements ConoDeNieve {

    private ConoDeNieve heladoEspecial;
    private double precio = 25.0;

    public HeladoDecorator(ConoDeNieve heladoEspecial) {
        this.heladoEspecial = heladoEspecial;
        this.precio = 25.0;
    }

    @Override
    public String hacerHelado() {

        return heladoEspecial.hacerHelado() ;
    }

    public double imprimirPrecio() { return  precio;}

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio += precio;
    }

}

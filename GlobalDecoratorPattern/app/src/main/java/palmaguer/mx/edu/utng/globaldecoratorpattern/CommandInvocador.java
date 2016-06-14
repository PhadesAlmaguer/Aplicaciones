package palmaguer.mx.edu.utng.globaldecoratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phades Almaguer on 13/05/2016.
 */
public class CommandInvocador {

    private List<CommandOrder> listaOrden =  new ArrayList<CommandOrder>();

    public void tomarOrden(CommandOrder orden){
        listaOrden.add(orden);
    }

    public void recorrer(){
        for (CommandOrder orden : listaOrden){
            orden.accion();
        }
        listaOrden.clear();
    }
}

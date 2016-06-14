package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by Phades Almaguer on 13/05/2016.
 */
public class CommandComprarAlmacen implements CommandOrder {

    private CommandAlmacen almacen;

    @Override
    public void accion() {
        almacen.comprar();

    }

    public CommandComprarAlmacen(CommandAlmacen almacen) {
        this.almacen = almacen;
    }
}

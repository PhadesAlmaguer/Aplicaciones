package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by Phades Almaguer on 13/05/2016.
 */
public class CommandVentaAlmacen {

    private CommandAlmacen ventaAlmcacen;

    public CommandVentaAlmacen(CommandAlmacen ventaAlmcacen) {
        this.ventaAlmcacen = ventaAlmcacen;
    }

    public void accion(){
        ventaAlmcacen.vender();
    }


}

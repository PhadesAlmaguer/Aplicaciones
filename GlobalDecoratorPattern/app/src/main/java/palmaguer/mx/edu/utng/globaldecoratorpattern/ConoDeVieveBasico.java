package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by Phades Almaguer on 12/05/2016.
 */
public class ConoDeVieveBasico implements ConoDeNieve{

    private int precio = 20;
    @Override
    public String hacerHelado() {
        return "Helado basico";
    }
    public void agregar(){}

}

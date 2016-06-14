package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by Phades Almaguer on 12/05/2016.
 */
public class MielDocorator extends HeladoDecorator {

    public MielDocorator(ConoDeNieve heladoEspecial) {
        super(heladoEspecial);
    }

    public String HacerHelado(ConoDeNieve heladoEspecial) {
        return heladoEspecial.hacerHelado() + agregarMiel();
    }
    public int agregarMiel(){
        return 10;
    }

}

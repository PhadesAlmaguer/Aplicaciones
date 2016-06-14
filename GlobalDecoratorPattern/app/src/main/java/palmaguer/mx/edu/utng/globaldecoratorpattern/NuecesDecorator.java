package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by Phades Almaguer on 12/05/2016.
 */
public class NuecesDecorator extends HeladoDecorator {

    public NuecesDecorator(ConoDeNieve heladoESpecial) {
        super(heladoESpecial);
    }

    public String hacerHelado( ConoDeNieve heladoEspecial){
        return heladoEspecial.hacerHelado() + agregarNueces();
    }

    public int agregarNueces(){
        return 5;
    }

}

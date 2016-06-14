package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by palmaguer on 6/13/16.
 */
public class Singleton {

    private static Singleton INSTANCE = null;

    public static Singleton getInstance(){
        if (INSTANCE == null)    {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    private Singleton(){

    }
}

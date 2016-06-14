package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by palmaguer on 6/13/16.
 */
public class Adapter_VlcPlayer implements  Adapter_AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }
    @Override
    public void playMp4(String fileName) {
        //do nothing
    }

}

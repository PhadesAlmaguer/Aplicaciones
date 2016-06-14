package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by palmaguer on 6/13/16.
 */
public class    Adapter_Mp4Player implements Adapter_AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

package palmaguer.mx.edu.utng.globaldecoratorpattern;



/**
 * Created by palmaguer on 6/13/16.
 */
public class Adapter_MediaAdapter implements Adapter_MediaPlayer  {

    Adapter_AdvancedMediaPlayer advancedMusicPlayer;

    public Adapter_MediaAdapter(String audioType){

        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = (Adapter_AdvancedMediaPlayer) new Adapter_VlcPlayer(); //= new Adapter_VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = (Adapter_AdvancedMediaPlayer) new Adapter_Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }

}

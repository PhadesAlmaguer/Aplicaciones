package palmaguer.mx.edu.utng.globaldecoratorpattern;

/**
 * Created by palmaguer on 6/13/16.
 */
public class Adapter_AudioPlayer implements Adapter_MediaPlayer {

    Adapter_MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        //inbuilt support to play mp3 music files
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);

        }
        //mediaAdapter is providing support to play other file formats
        else if(audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new Adapter_MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }

}

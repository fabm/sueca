package jogosueca.cliente;



import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class SoundManager extends ResourceCache {
    
        protected Object loadResource(URL url){
        return Applet.newAudioClip(url);
    }
    
    public AudioClip getAudioClip(String name){
        return (AudioClip) getResource (name);
    }
    
    public void playSong(final String name){
        new Thread(
                new Runnable(){
                    @Override
            public void run(){
                getAudioClip(name).play();
            }
        }).start();
    }
    
    public void loopSong(final String name){
        new Thread(
                new Runnable(){
                    @Override
            public void run(){
                getAudioClip(name).loop();
            }
        }).start();
    }
    
    public void stopSong(final String name){
        new Thread(
                new Runnable(){
                    @Override
            public void run(){
                getAudioClip(name).stop();
            }
        }).start();
    }    
}

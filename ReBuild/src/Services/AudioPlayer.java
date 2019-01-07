package Services;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
    public static Map<String,Music> music = new HashMap<String,Music>();
    public static Map<String,Sound> sound = new HashMap<String,Sound>();

    public static void setUpMusicAndSound(){
        try {
            
            music.put("background", new Music("resource/music/background.wav"));
            music.put("menu", new Music("resource/music/menu.wav"));
            music.put("game_end", new Music("resource/music/game_end.wav"));
            
            sound.put("chomp", new Sound("resource/music/chomp.wav"));
            sound.put("zombies_coming", new Sound("resource/music/zombies_coming.wav"));
        
        
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
    public static Music loadMusic(String name){
        return music.get(name);
    }
    public static Sound loadSound(String name){
        return sound.get(name);
    }
    
}

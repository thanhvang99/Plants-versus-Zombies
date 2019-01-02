package Resources;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage load(String path){
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
            
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
}

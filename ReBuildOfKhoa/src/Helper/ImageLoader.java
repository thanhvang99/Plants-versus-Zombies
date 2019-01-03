/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ldakhoa
 */
public class ImageLoader {
    
    public static BufferedImage load(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch(IOException err) {
            err.printStackTrace();
            return null;
        }
    }
    
}

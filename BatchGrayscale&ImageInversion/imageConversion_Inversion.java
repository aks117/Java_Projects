
/**
 * Write a description of imageConversion_Inversion here.
 * 
 * @author Akshunn Sharma
 * @version 4.1.1-duke
 */

import edu.duke.*;
import java.io.*;

public class imageConversion_Inversion {
    
        public ImageResource convertGray ( ImageResource inImage) {
            ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
            
            for (Pixel pixel : outImage.pixels()) {
                
                Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                
                int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
                
                pixel.setRed(average);
                pixel.setBlue(average);
                pixel.setGreen(average);
                
        }
        
        return outImage;
    }
    
    public void selectForGray () {
        DirectoryResource dr = new DirectoryResource();
        
        for ( File f : dr.selectedFiles()) {
            
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = convertGray(inImage);
            
            String fName = inImage.getFileName();
            String newName = "grey-" + fName;
            gray.setFileName(newName);
            
            gray.draw();
            gray.save();
            
        }
    }

}

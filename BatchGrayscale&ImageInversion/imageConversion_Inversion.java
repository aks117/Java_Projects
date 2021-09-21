
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
    
        public ImageResource imageInverter (ImageResource inImage) {
            ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
            
            for ( Pixel pixel : outImage.pixels()) {
                Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                
                int inRed = inPixel.getRed();
                int newRed = 255-inRed;
                pixel.setRed(newRed);
                
                int inBlue = inPixel.getBlue();
                int newBlue = 255-inBlue;
                pixel.setBlue(newBlue);
                
                int inGreen = inPixel.getGreen();
                int newGreen = 255-inGreen;
                pixel.setGreen(newGreen);            
                
                
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
    
    public void selectForInvert () {
        DirectoryResource dr = new DirectoryResource();
        
        for ( File f : dr.selectedFiles()) {
            
            ImageResource inImage = new ImageResource(f);
            ImageResource inverted = imageInverter(inImage);
            
            String fName = inImage.getFileName();
            String newName = "inverted-" + fName;
            inverted.setFileName(newName);
            
            inverted.draw();
            inverted.save();
        }
    }

}

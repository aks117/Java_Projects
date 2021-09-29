
/**
 * Write a description of MostFrequentWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class MostFrequentWord {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public MostFrequentWord () {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        
        FileResource resource = new FileResource();
        
        for ( String word : resource.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            
            if ( index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
            
        }
        
    }
    
    public void findIndexOfMax() {
        int value = myFreqs.get(0);
        int maxIndex = value;
        String word = myWords.get(0);
        String maxWord = word;
        
        for ( int k =0; k<myFreqs.size(); k++) {
            int index = myFreqs.get(k);
            word = myWords.get(k);
            
            if (index>maxIndex) {
                maxIndex = index;
                maxWord = word;
            }
            
        }
        
        System.out.println("The word that occurs maximum times is : " + maxWord + " and it occures " + maxIndex + " times.");
        
    }
    
    public void tester() {
        findUnique();
        System.out.println("Number of Unique Words : " + myWords.size());
        int count = 0;
        
        for ( int k=0; k<myWords.size(); k++) {
            System.out.println(myWords.get(k) + "\t\t" + myFreqs.get(k));
            count++;
        }
        
        //System.out.println("Number of Unique words : " + count);
        findIndexOfMax();
    }

}

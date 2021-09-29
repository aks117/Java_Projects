
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    
    private ArrayList<String> characterNames;
    private ArrayList<Integer> nameCount;
    
    public CharactersInPlay() {
        characterNames = new ArrayList<String>();
        nameCount = new ArrayList<Integer>();
    }
    
    public void update (String person) {
        
        if (characterNames.indexOf(person) == -1) {
            characterNames.add(person);
            nameCount.add(1);
        }
        
        else {
            int indexCounts = nameCount.get(characterNames.indexOf(person)) + 1;
            nameCount.set(characterNames.indexOf(person), indexCounts);
        }
        
    }
    
    public void findAllCharacters() {
        FileResource resource = new FileResource();
        String firstOccurance = "";
        
        for ( String line : resource.lines() ) {
            if ( line.indexOf(".") != -1) {
                firstOccurance = line.substring(0, line.indexOf("."));
                update(firstOccurance);
            }
        }
    }
    
    public void charactersWithParts (int num1, int num2) {
        System.out.println("Characters that have between " + num1 + " and " + num2 + " lines : ");
        for ( int k=0; k<characterNames.size(); k++) {
            if (nameCount.get(k) >= num1 && nameCount.get(k) <= num2) {
                System.out.println(characterNames.get(k) + "\t" + nameCount.get(k));
            }
        }
    }
    
    public void tester() {
        characterNames.clear();
        nameCount.clear();
        findAllCharacters();
        
        for ( int k =0; k< characterNames.size(); k++) {
            if (nameCount.get(k) >1) {
                System.out.println(characterNames.get(k) + "\t" + nameCount.get(k));
            }            
        }
        
    }
    
}

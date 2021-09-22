
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarCipher {
    
    public String encrypt ( String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        String shiftedSmallAlphabet = smallAlphabet.substring(key) + smallAlphabet.substring(0, key);
        
        for ( int i = 0; i < encrypted.length(); i++ ) {
            char currChar = encrypted.charAt(i);
            
            if ( Character.isLowerCase(currChar) ) {
                int index = smallAlphabet.indexOf(currChar);
                char newChar = shiftedSmallAlphabet.charAt(index);
                
                encrypted.setCharAt(i, newChar);                
            }
            
            else if ( Character.isUpperCase(currChar)) {
                int index = alphabet.indexOf(currChar);
                char newChar = shiftedAlphabet.charAt(index);
                
                encrypted.setCharAt(i, newChar); 
                
            }
            
        }
        
        return encrypted.toString();
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedSmallAlphabet1 = smallAlphabet.substring(key1) + smallAlphabet.substring(0, key1);
        
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        String shiftedSmallAlphabet2 = smallAlphabet.substring(key2) + smallAlphabet.substring(0, key2);
        
        for ( int i = 0; i < encrypted.length(); i++ ) {
            char currChar = encrypted.charAt(i);
            
            if ( Character.isLowerCase(currChar) ) {
                int index = smallAlphabet.indexOf(currChar);
                
                if ( i % 2 == 0) {
                    char newChar = shiftedSmallAlphabet1.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
                else {
                    char newChar = shiftedSmallAlphabet2.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
                           
            }
            
            else if ( Character.isUpperCase(currChar)) {
                int index = alphabet.indexOf(currChar);
                
                if ( i % 2 == 0) {
                    char newChar = shiftedAlphabet1.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
                else {
                    char newChar = shiftedAlphabet2.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
                
                
            }
            
        }
        
        return encrypted.toString();
    }
    
    public void tester () {
        // Testing encrypt()
        
        /*
        int key = 15;        
        String encrypted = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", key);
        System.out.println("key is " + key + "\n" + encrypted);
        */
        //key = 17;
        //encrypted = encrypt("First Legion", key);
        //System.out.println("key is " + key + "\n" + encrypted);
        
        // Testing encryptTwoKeys()
        
        String encrypted;
        int key1 = 8;
        int key2 = 21;
        encrypted = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", key1, key2 );
        System.out.println("key1 is " + key1 + "key2 is " + key2 +  "\n" + encrypted);
        
        
    }

}

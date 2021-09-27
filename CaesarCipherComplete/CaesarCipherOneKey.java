
/**
 * Write a description of CaesarCipherOneKey here.
 * 
 * @author Akshunn Sharma 
 * @version 4.1.1-duke
 */

import java.io.*;


public class CaesarCipherOneKey {
    
    private String alphabet;
    private String smallAlphabet;
    private String shiftedAlphabet;
    private String shiftedSmallAlphabet;
    private int mainKey;
    
    public CaesarCipherOneKey (int key) {
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        shiftedSmallAlphabet = smallAlphabet.substring(key) + smallAlphabet.substring(0, key);
    }
    
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
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
    
    public String decrypt (String input) {
        CaesarCipherOneKey cc = new CaesarCipherOneKey(26 - mainKey);
        String decrypt = cc.encrypt(input);
        return decrypt;
    }

}

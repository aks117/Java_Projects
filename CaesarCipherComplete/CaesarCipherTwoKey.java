
/**
 * Write a description of CaesarCipherTwoKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwoKey {
    
    private String alphabet;
    private String smallAlphabet;
    
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private String shiftedSmallAlphabet1;
    private String shiftedSmallAlphabet2;
    
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwoKey(int key1, int key2) {
        mainKey1 = key1;
        mainKey2 = key2;
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedSmallAlphabet1 = smallAlphabet.substring(key1) + smallAlphabet.substring(0, key1);
        
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        String shiftedSmallAlphabet2 = smallAlphabet.substring(key2) + smallAlphabet.substring(0, key2);
        
    }
    
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
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
    
    public String decrypt (String input) {       
        CaesarCipherTwoKey cc = new CaesarCipherTwoKey( 26-mainKey1, 26-mainKey2);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }

}

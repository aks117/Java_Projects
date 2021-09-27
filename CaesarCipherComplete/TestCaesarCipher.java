
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    
    public void testCaesarCipherOneKey () {
        CaesarCipherOneKey ccok = new CaesarCipherOneKey(8);
        String message = "A quick brown FOx jumps over A lazy dOG!";
        String encryptedMessage = ccok.encrypt(message);
        System.out.println("The encrypted message is : \n" + ccok.encrypt(message));
        System.out.println("The decrypted message is : \n" + ccok.decrypt(encryptedMessage));
        
    }
    
    public void testCaesarCipherTwoKey () {
        CaesarCipherTwoKey cctk = new CaesarCipherTwoKey(4, 23);
        String message = "A quick brown FOx jumps over A lazy dOG!";
        String encryptedMessage = cctk.encrypt(message);
        System.out.println("The encrypted message is : \n" + cctk.encrypt(message));
        System.out.println("The decrypted message is : \n" + cctk.decrypt(encryptedMessage));
    }
    

}

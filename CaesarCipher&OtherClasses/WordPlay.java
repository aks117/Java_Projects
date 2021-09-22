
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public boolean isVowel (char ch) {
        
        if ( ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' ||
            ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
                return true;
            }
        return false;
    }
    
    public String replaceVowels (String phrase, char ch) {
        
        StringBuilder str = new StringBuilder(phrase);
        
        for (int i=0; i<str.length(); i++) {
            
            char currChar = str.charAt(i);
            
            if( isVowel(currChar)) {
                str.setCharAt(i, ch);
            }
        }
        
        return str.toString();
    }
    
    public String emphasize ( String phrase, char ch) {
        
        StringBuilder str = new StringBuilder(phrase);
        
        char chLower = Character.toLowerCase(ch);
        char chUpper = Character.toUpperCase(ch);
        
        for ( int i = 0; i<str.length(); i++) {
           char currChar = str.charAt(i);
           
           if ( currChar == chLower || currChar == chUpper ) {
               
               if (i % 2 == 0) {
                   str.setCharAt(i, '+');
                }
                
               else {
                   str.setCharAt(i, '*');
                }
            
            }
        }
        
        return str.toString();
    }
    
    public void wordPlayTester() {
        // Testing isVowel()
        /*char ch = 'a';
        System.out.println( ch + " is a vowel " + isVowel(ch));
        ch = 'x';
        System.out.println( ch + " is a vowel " + isVowel(ch));
        */
        
        // Testing replaceVowel()
        /*char ch = '#';
        String str = "A quick brown fOx jumpEd over a Lazy dog";
        System.out.println("The string is : " + str + " and the character is : " + ch);
        System.out.println("\nThe new string is : \n" + replaceVowels(str, ch));
        
        ch = '%';
        str = "Harry POtter is a Wizard Kid";
        System.out.println("The string is : " + str + " and the character is : " + ch);
        System.out.println("\nThe new string is : \n" + replaceVowels(str, ch));
        */
       
        // Testing emphasize()
        char ch = 'a';
        String str = "A quick brown fOx jumpEd over a Lazy dog";
        System.out.println("The string is : " + str + " and the character is : " + ch);
        System.out.println("\nThe new string is : \n" + emphasize(str, ch));
        
        ch = 'r';
        str = "Harry POtter is a Wizard Kid";
        System.out.println("The string is : " + str + " and the character is : " + ch);
        System.out.println("\nThe new string is : \n" + emphasize(str, ch));
    }
}

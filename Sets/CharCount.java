import java.util.*; // for Scanner

public class CharCount {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter a string: ");
      String input = scanner.nextLine();

      /* using no arrays, no data structures
       * scan the string and count how many times that letter appears? 
       * logic is clear but it's very inefficient
      */
      for (char letter = 'a'; letter <= 'z'; letter++) {
            int count = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == letter) {
                    count++;
                }
            }

            if (count > 0) {
                System.out.println("'" + letter + "' : " + count);
            }
        }   
              
        
      // using an array
      
      int[] freq = new int[256]; // Assuming extended ASCII

      for (int i=0; i<input.length(); i++) {
            int ch = input.charAt(i);
            freq[ch]++;
      }
        
      System.out.println("\nCharacter counts:");
      for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println("'" + (char) i + "' : " + freq[i]);
            }
      }
       
      
      
    }
}

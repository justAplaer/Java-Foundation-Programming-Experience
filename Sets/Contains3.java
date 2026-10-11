import java.util.*;

public class Contains3 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple"); words.add("banana"); words.add("apple");
        words.add("cherry"); words.add("apple");
        
        System.out.println(words + ":: " + contains3(words)); // Output: true

        words.remove(0);
        System.out.println(words + ":: " + contains3(words)); // Output: false
    }

    public static boolean contains3 (List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String target = list.get(i);
            int count = 0;

            // Count occurrences of target in the list
            for (String s : list) {
                if (s.equals(target)) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}

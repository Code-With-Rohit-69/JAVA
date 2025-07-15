public class OptimizedAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int frequency[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        
        return true;
        // for (int i = 0; i < t.length(); i++) {
        //     char ch = ;
        // }
    }
    
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        System.out.println(isAnagram(str1, str2));

        // int frequency[] = new int[26];

        // for (int i = 0; i < str1.length(); i++) {
        //     char ch = str1.charAt(i);
        //     frequency[ch - 'a']++;
        // }

        // for (int i = 0; i < str2.length(); i++) {
        //     char ch = str2.charAt(i);
        //     frequency[ch - 'a']--;
        // }

        // for (int i = 0; i < frequency.length; i++) {
        //     if (frequency[i] == 1) {
        //         System.out.println("Strings are not anagram");
        //         break;
        //     }
        // }

        // for (int i = 0; i < frequency.length; i++) {
        //     System.out.print(frequency[i] + "  ");
        // }
    }
}

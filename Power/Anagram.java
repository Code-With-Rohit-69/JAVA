public class Anagram {

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int frequency[] = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i) - 'a']++ ;
            frequency[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;

    }
    
    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nbaagrm";

        System.out.println(isAnagram(str1, str2));
    }
}

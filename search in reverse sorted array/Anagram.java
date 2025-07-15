import java.util.Arrays;

public class Anagram {

    // public static boolean isAnagram(String str1, String str2) {
    //     if (str1.length() != str2.length()) {
    //         return false;
    //     }

    //     int frequency[] = new int[26];

    //     for (int i = 0; i < str1.length(); i++) {
    //         char ch = str1.charAt(i);
    //         frequency[ch - 'a']++;
    //         frequency[str2.charAt(i) - 'a']--;
    //     }
    //     for (int i = 0; i < frequency.length; i++) {
    //         if (frequency[i] != 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();

        Arrays.sort(str1CharArray);
        Arrays.sort(str2CharArray);

        for (int i = 0; i < str2CharArray.length; i++) {
            if (str1CharArray[i] != str2CharArray[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "naaagrm";

        System.out.println(isAnagram(str1, str2));
    }
}

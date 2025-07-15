import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        char newStr1[] = str1.toCharArray();
        Arrays.sort(newStr1);

        str2 = str2.toLowerCase();
        char newStr2[] = str2.toCharArray();
        Arrays.sort(newStr2);

        for (int i = 0; i < newStr1.length; i++) {
            if (newStr1[i] != newStr2[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "Care";

        char newStr1[] = str1.toCharArray();
        Arrays.sort(newStr1);

        char newStr2[] = str2.toCharArray();
        Arrays.sort(newStr2);

        System.out.println(isAnagram(str1, str2));
    }
}
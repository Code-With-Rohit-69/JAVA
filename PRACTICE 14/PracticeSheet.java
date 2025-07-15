import java.util.Scanner;

public class PracticeSheet {

    public static int checkLowercaseVowels(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                count++;
            }
        }

        return count;
    }

    public static boolean isAnagrams(String str1, String str2) {
        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                char ith = str1.charAt(i);
                for (int j = 0; j < str2.length(); j++) {
                    if (ith == str2.charAt(j)) {
                        continue;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.print("Write a String: ");
        // String str = sc.next();

        // int result = checkLowercaseVowels(str);

        // System.out.println("Total numbers of vowles are: " + result);

        // String str = "ShardhaDidi";
        // String str1 = "ApnaCollege";
        // String str2 = "ShardhaDidi";

        // System.out.print(str.equals(str1) + " " + str.equals(str2));

        // String str = "ApnaCollege".replace("l", "");

        // System.out.println(str);
        System.out.print("Enter the 1st String: ");
        String str1 = sc.next();
        System.out.print("Enter the 2nd String: ");
        String str2 = sc.next();

        boolean result = isAnagrams(str1, str2);

        if (result) {
            System.out.print(str1 + " and " + str2 + " both are anagrams.");
        } else {
            System.out.print(str1 + " and " + str2 + " are not anagrams.");
        }

        sc.close();
    }
}

import java.util.*;

public class CountVowels {

    public static int countvowels(String str) {
        int vowels = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u') {
                vowels++;
            }
        }

        return vowels;

    }

    public static int countConsonant(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        int vowels = countvowels(str);
        int consonant = countConsonant(str);

        System.out.println("Vowels: " + vowels + "\nconsonant: " + consonant);

        sc.close();
    }
}

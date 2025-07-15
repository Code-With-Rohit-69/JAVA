public class Problem2 {

    public static boolean isPallindrome(String str) {

        str = str.toLowerCase();

        int startingChar = 0;
        int endingChar = str.length() - 1;

        while (startingChar < endingChar) {

            if (!Character.isLetterOrDigit(str.charAt(startingChar))) {
                startingChar++;
            } else if (!Character.isLetterOrDigit(str.charAt(endingChar))) {
                endingChar--;
            } else {
                if (str.charAt(startingChar) != str.charAt(endingChar)) {
                    return false;
                }

                startingChar++;
                endingChar--;
            }

        }

        return true;

    }

    public static void main(String[] args) {
        // String str = "A Santa @! Lived #as a !Devil@ At NASA";
        String str = "Madam, in Eden, I'm Adam";

        System.out.println(isPallindrome(str));
    }
}
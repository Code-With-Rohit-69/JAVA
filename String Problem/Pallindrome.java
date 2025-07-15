public class Pallindrome {

    public static boolean validPallindrome(String s) {
        int timeToAvoidChar = 0;

        for (int i = 0; i*i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                if (timeToAvoidChar == 1) {
                    return false;
                }   
                timeToAvoidChar++ ;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abc";

        System.out.println(validPallindrome(str));
    }
}

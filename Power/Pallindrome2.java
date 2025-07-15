public class Pallindrome2 {

    public static boolean isPallindrome(String str) {
        str = str.toLowerCase();

        int start = 0;
        int end = str.length()-1;

        while (start < end) {
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++ ;
            } else if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            } else {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }

                start++ ;
                end-- ;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String str = "abcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcbaabcdeffedcba";

        System.out.println(isPallindrome(str));
    }
}

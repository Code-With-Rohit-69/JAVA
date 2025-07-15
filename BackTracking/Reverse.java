public class Reverse {

    public static void reverseString(char[] s) {
        char[] newStr = new char[s.length];

        int start = 0;
        int end = s.length-1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        // for(int i = 0; i < s.length; i++) {
        //     newStr[i] = s[s.length-i-1];
        // }

        // for (int i = 0; i < s.length; i++) {
        //     System.out.print(s[i] + " ");
        // }
    }
    
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
}

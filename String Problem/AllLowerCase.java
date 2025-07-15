public class AllLowerCase {

    public static String toLowerCase(String str) {
        str = str.toLowerCase();
        return str;
        // String newStr = new String("");

        // for (int i = 0; i < str.length(); i++) {
        //     char currChar = str.charAt(i);
        //     if (currChar == Character.toUpperCase(currChar)) {
        //         newStr += Character.toLowerCase(currChar);
        //     }
        //     else {
        //         newStr += currChar;
        //     }
        // }

        // return newStr;
    }
    
    public static void main(String[] args) {
        String str = "Hello";

        System.out.println(toLowerCase(str));
    }
}

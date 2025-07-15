public class Problem58 {

    public static int lengthOfLastWord(String s) {

        String []str = s.split("\\s+");
        String string = "";

        for (int i = str.length-1; i > str.length-2; i--) {
            string = str[i];
        }

         return string.length();
    }
    
    public static void main(String[] args) {
        String s = "Hello World";
        // String s = "luffy is still joyboy";
        int result = lengthOfLastWord(s);
        System.out.println(result);
    }
}

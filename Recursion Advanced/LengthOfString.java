public class LengthOfString {

    public static int lengthOfString(String str, int count, int idx) {

        if (idx == str.length()) {
            return count;
        }

        return lengthOfString(str, count + 1, idx + 1);
    }

    public static void main(String[] args) {
        String str = "Rohit singh koranga";
        int result = lengthOfString(str, 0, 0);
        System.out.println(result);
    }
}

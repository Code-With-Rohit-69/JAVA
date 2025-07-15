public class ReverseWords {

    public static void print(char str[]) {
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] + " ");
        }
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        char[] charArr = s.toCharArray();
        print(charArr);
    }
}
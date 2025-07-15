public class Pattern {
    public static void main(String[] args) {
        // System.out.println(Character.toString((char)(ch + 2)));
        char ch = 'A';

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}

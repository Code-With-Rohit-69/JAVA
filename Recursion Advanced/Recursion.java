public class Recursion {

    public static void towerOfHanoi(int n, char A, char C, char B) {

        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, A, B, C);
        System.out.println("Moving disc " + n + " from " + A + " to " + C);
        towerOfHanoi(n - 1, B, C, A);
    }

    // This is the function which return a string with unique letters
    public static String removeDuplString(String s) {
        StringBuilder sb = new StringBuilder();

        boolean map[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (map[currChar - 'a'] != true) {
                sb.append(currChar);
                map[currChar - 'a'] = true;
            }

        }

        return sb.toString();
    }

    // This is the function which return a string with unique letters with the help of recursion
    public static String removeDupStringRecursion(String s, int idx, StringBuilder sb, boolean map[]) {

        if (idx == s.length()) {
            return sb.toString();
        }

        char currChar = s.charAt(idx);

        if (map[currChar - 'a'] != true) {
            sb.append(currChar);
            map[currChar - 'a'] = true;
        }

        return removeDupStringRecursion(s, idx + 1, sb, map);
    }

    public static int tilings(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return tilings(n-1) + tilings(n-2);
    }

    public static void main(String[] args) {
        // towerOfHanoi(3, 'A', 'C', 'B');
        // String s = "appnnacollege";
        // int idx = 0;
        // StringBuilder sb = new StringBuilder();
        // boolean map[] = new boolean[26];

        // String result = removeDupStringRecursion(s, idx, sb, map);
        // System.out.println(result);

        // System.out.println(tilings(6));

    }
}
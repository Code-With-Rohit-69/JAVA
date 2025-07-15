public class Problem443 {

    public static int compress(char[] chars) {

        // if (chars.length == 1) {
        //     return 1;
        // }   

        String str = "";
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            str += chars[i];
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;

            while (i < str.length() - 1 && ch == str.charAt(i + 1)) {
                count++;
                i++;
            }

            chars[index] = ch;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // char chars[] = { 'a' };
        char chars[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
        'b' };
        // char chars[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

        System.out.println(compress(chars));
    }
}
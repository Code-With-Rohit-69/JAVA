public class Compression {

    public static int compress(char chars[]) {
        String s = "";

        for (int i = 0; i < chars.length; i++) {
            s += chars[i];
        }

        System.out.println(s);

        String newStr = "";

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int count = 1;

            while (i < s.length()-1 && currChar == s.charAt(i+1)) {
                count += 1;
                i++;
            }

            newStr += currChar;

            if (count > 1) {
                newStr += count;
            }

        }

        chars = newStr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();

        System.out.println(newStr);

        return chars.length;
    }
    
    public static void main(String[] args) {
        // char chars[] = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char chars[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
    }
}

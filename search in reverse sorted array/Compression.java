public class Compression {

    public static String compress(String str) {

        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char ch = str.charAt(i);

            while (i < str.length()-1 && str.charAt(i+1) == ch) {
                count++ ;
                i++ ;
            }

            newStr.append(ch);

            if (count > 1) {
                newStr.append(count);
            }

        }

        return newStr.toString();
    }
    
    public static void main(String[] args) {
        String str = "aaabbcc";
        System.out.println(compress(str));
    }
}

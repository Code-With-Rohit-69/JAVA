public class EncodedStringToCountTheFrequencyOfCharacter {

    public static void main(String[] args) {
        String s = "12310#11#12";

        StringBuilder sb = new StringBuilder();

        int n = s.length();

        int i = n - 1;
        int repeat = 0;

        while (i > 0) {
            char ch = s.charAt(i);
            if (ch == ')') {
                int place = 1;
                i--;

                while (s.charAt(i) != '(') {

                    int digit = s.charAt(i) - '0';

                    repeat = (digit * place) + repeat;

                    i--;
                    place *= 10;
                }

            } else if (ch == '#') {
                String substr = s.substring(i - 2, i);

                char chr = (char) ('a' + (Integer.parseInt(substr) - 1));

                if (repeat != 0) {
                    sb.repeat(chr, repeat);
                    repeat = 0;
                } else {
                    sb.append(chr);
                }

                i -= 2;

            } else {
                String substr = s.substring(i - 1, i);

                char chr = (char) ('a' + Integer.parseInt(substr));

                sb.append(chr);
            }

            i--;
        }

        if(i == 0) {
            char ch = (char) ('a' + ((s.charAt(i) - '0') - 1));
            sb.append(ch);
        }

        String ans = sb.reverse().toString();

        System.out.println(ans);

        int[] freq = new int[26];

        for (int j = 0; j < ans.length(); j++) {
            int index = ans.charAt(j) - 'a';
            freq[index]++;
        }

        for (int j = 0; j < freq.length; j++) {
            System.out.print(freq[j] + " ");
        }

    }
}

/*
 * 
 * first i have to check for paranthesis
 * then hashtag
 * then after i will go for one characters
 * 
 */
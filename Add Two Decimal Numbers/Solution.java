public class Solution {

    public static String addString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        int i = s1.length() - 1, j = s2.length() - 1;

        while (i >= 0 || j >= 0) {

            if (i >= 0 && j >= 0 && s1.charAt(i) == '.' && s2.charAt(j) == '.') {
                sb.append('.');
                i--;
                j--;
                continue;
            }

            int digit1 = i < 0 ? 0 : (s1.charAt(i) - '0');
            int digit2 = j < 0 ? 0 : (s2.charAt(j) - '0');

            int add = digit1 + digit2 + carry;

            int module = add % 10;

            carry = add / 10;
            sb.append(module);

            i--;
            j--;

        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "12322.22", s2 = "23.233";

        if (!s1.contains("."))
            s1 += ".";
        if (!s2.contains("."))
            s2 += ".";

        int d1 = s1.length() - s1.indexOf('.');
        int d2 = s2.length() - s2.indexOf('.');

        if (d1 < d2) {
            s1 += "0".repeat(d2 - d1);
        } else {
            s2 += "0".repeat(d1 - d2);
        }

        String res = addString(s1, s2);

        System.out.println(res);

    }
}

import java.util.*;

public class FileNames {

    public static String[] getFolderNames(String[] names) {
        HashSet<String> set = new HashSet<>();

        // String[] ans = new String[names.length];

        int i = 0;

        for (String name : names) {
            if (!set.contains(name)) {
                set.add(name);
            } else {
                int k = 1;

                StringBuilder sb = new StringBuilder(name);
                sb.append('(').append(k).append(")");

                while (set.contains(sb.toString())) {
                    int index = sb.indexOf("(");
                    String substr = sb.substring(0, index + 1);
                    sb = new StringBuilder();
                    k++;
                    sb.append(substr).append(k).append(")");
                }

                set.add(sb.toString());
                names[i] = sb.toString();
            }
            i++;
        }

        return names;
    }

    public static void print(String arr[]) {
        for (String a : arr) {
            System.out.print(a + ", ");
        }
    }

    public static void comparison(String arr[]) {
        String[] output = {
            "l","p(4)(4)","v","c","i","k(2)","y","a(4)(2)","t","a","e","e(1)(4)","p","p(1)","s","z","s(1)","q(2)(1)","r(1)","m","b(3)","u(2)","j","p(2)","t(1)","s(2)","g","o","o(1)","b(3)(3)","k","w(2)(3)","q","a(1)","z(1)","t(4)(4)","s(2)(1)","c(1)","w","u","h","g(1)","b","r","c(1)(1)","v(1)","n(1)","r(2)(1)","u(1)","t(2)(3)","p(3)","m(3)(1)","h(1)","o(2)","y(1)","n","s(3)","z(2)","k(2)(1)","x(4)","l(1)(4)","g(2)","u(3)","t(2)","m(1)","c(2)","t(3)","g(3)","c(3)","a(2)","r(2)","d","y(2)","b(1)","p(4)","m(2)","w(2)(4)","v(2)","t(4)(2)","x","e(4)(1)","h(2)","f","z(3)","e(1)(4)(1)","t(4)","b(1)(1)","x(4)(1)","m(3)","j(2)(4)","s(3)(2)","z(4)","l(1)","p(2)(2)","g(3)(2)","q(1)(4)","h(1)(1)","h(3)","o(3)","h(4)","f(1)","n(4)","s(4)","g(4)","s(5)","r(3)","n(1)(1)","x(3)","r(4)","f(3)(1)","e(1)","j(1)","s(6)","g(5)","d(1)","l(2)","g(6)","o(4)(3)","x(4)(2)","u(2)(4)","x(1)","t(5)","f(2)","j(1)(1)","v(2)(1)","w(1)","v(3)","t(2)(2)","l(3)","o(1)(1)","a(3)","y(3)","q(4)","m(1)(2)","i(1)","u(4)","l(4)","c(1)"
        };

        System.out.println("output: " + output.length + " arr: " + arr.length);

        for(int i = 0; i < output.length; i++) {
            if(!output[i].equals(arr[i])) {
                System.out.println("Not equal at " + i + " String " + output[i]);
            }
        }
    }

    public static void main(String[] args) {
        // String names[] = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)",
        // "onepiece(4)", "onepiece(5)", "onepiece(6)", "onepiece(7)", "onepiece(8)",
        // "onepiece(9)", "onepiece", "onepiece" };
        String names[] = { "l", "p(4)(4)", "v", "c", "i", "k(2)", "y", "a(4)(2)", "t", "a", "e", "e(1)(4)", "p", "p",
                "s", "z", "s", "q(2)(1)", "r(1)", "m", "b(3)", "u(2)", "j", "p", "t", "s", "g", "o", "o", "b(3)(3)",
                "k", "w(2)(3)", "q", "a", "z", "t(4)(4)", "s(2)", "c", "w", "u", "h", "g", "b", "r", "c(1)", "v",
                "n(1)", "r(2)(1)", "u", "t(2)(3)", "p", "m(3)(1)", "h", "o", "y", "n", "s", "z", "k(2)", "x(4)",
                "l(1)(4)", "g(2)", "u", "t(2)", "m", "c", "t", "g", "c", "a(2)", "r", "d", "y", "b", "p", "m",
                "w(2)(4)", "v", "t(4)(2)", "x", "e(4)(1)", "h", "f", "z", "e(1)(4)", "t", "b(1)", "x(4)", "m(3)",
                "j(2)(4)", "s(3)(2)", "z", "l", "p(2)(2)", "g(3)(2)", "q(1)(4)", "h(1)(1)", "h", "o(3)", "h", "f",
                "n(4)", "s(4)", "g", "s", "r", "n(1)(1)", "x(3)", "r", "f(3)(1)", "e", "j", "s", "g", "d", "l", "g",
                "o(4)(3)", "x(4)", "u(2)(4)", "x", "t", "f", "j(1)", "v(2)", "w", "v", "t(2)(2)", "l", "o(1)(1)", "a",
                "y", "q(4)", "m(1)(2)", "i", "u", "l", "c(1)", "g", "l(2)", "p(1)(1)", "k", "d", "l", "o", "m", "i(1)",
                "j", "i", "f", "y", "b", "k", "z", "n", "t", "c(2)", "y", "q", "b", "t", "m", "g(1)", "r", "m", "l",
                "s", "n", "j(4)(4)", "m(3)(3)", "n", "n(2)(3)", "s", "t", "l", "e", "p", "q(2)", "v", "v" };

        // String names[] = { };

        String[] ans = getFolderNames(names);
        comparison(ans);
        // print(ans);

    }
}
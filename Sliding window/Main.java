import java.util.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int max = 0;
            int curr = 0;

            for(int i = 0; i < n; i++) {
                if((i + 1) % 2 != 0) { // odd
                    if(s.charAt(i) == 'u' || s.charAt(i) == 'o') curr++;
                    else curr = 0;
                } else {
                    if(s.charAt(i) == 'w') curr++;
                    else curr = 0;
                }

                max = Math.max(max, curr);
                System.out.println(curr + " " + max);
            }

            max = Math.max(max, curr);

            System.out.println(max);

        }

        sc.close();

    }
}

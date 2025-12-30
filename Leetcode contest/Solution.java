import java.util.*;

public class Solution {

    public static boolean[] primes(int num) {
        boolean[] prime = new boolean[num + 1];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public static boolean prefixHelper(int num, boolean[] prime) {
        String s = Integer.toString(num);

        String prefix = "";

        for (char ch : s.toCharArray()) {
            prefix += ch;
            if (!prime[Integer.parseInt(prefix)]) {
                return false;
            }
        }

        return true;
    }

    public static boolean suffixHelper(int num, boolean[] prime) {
        int current = num;

        if (current > prime.length - 1 || !prime[current]) {
            return false;
        }

        while (current >= 10) {
            current /= 10;

            if (current > prime.length - 1 || !prime[current]) {
                return false;
            }
        }
        return true;
    }

    public static boolean completePrime(int num) {
        boolean[] prime = primes(num);

        boolean prefix = prefixHelper(num, prime);

        if (!prefix) {
            return false;
        }

        boolean suffix = suffixHelper(num, prime);

        return suffix;
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(completePrime(num));
    }

}
import java.util.Scanner;

public class CountPrime {

    public static int allPrimes(int n) {
        boolean prime[] = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {

            if (prime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println(allPrimes(num));

        // boolean prime[] = allPrimes(num);

        sc.close();
    }
}

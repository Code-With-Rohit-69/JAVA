import java.util.Scanner;

public class Prime {

    public static boolean[] sieveOfEra(int n) {
        boolean prime[] = new boolean[n+1];

        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lowerbound: ");
        int lowerbound = sc.nextInt();
        System.out.print("Enter Upperbound: ");
        int upperbound = sc.nextInt();

        boolean prime[] = sieveOfEra(upperbound);

        for (int i = lowerbound; i <= upperbound; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        sc.close();
    }
}
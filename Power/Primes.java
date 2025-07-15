import java.util.Arrays;
import java.util.Scanner;

public class Primes {

    public static int primeCount(int n) {
        boolean prime[] = new boolean[n+1];
        int count = 0;

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (prime[i]) {
                count++ ;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER A NUMBER: ");
        int num = sc.nextInt();

        System.out.println(primeCount(num));

        sc.close();
    }
}

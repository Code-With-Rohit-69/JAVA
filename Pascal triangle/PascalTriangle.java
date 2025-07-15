import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> mainList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                int data = nCr(i, j);
                list.add(data);
            }
            mainList.add(new ArrayList<>(list));
            System.out.println();
        }

        return mainList;
    }

    public static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static int nCr(int n, int r) {
        int factN = factorial(n);
        int factNmR = factorial(n - r);
        int factR = factorial(r);

        int output = factN / (factNmR * factR);

        return output;
    }

    public static void pascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            // gaps
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            // elements
            for (int j = 0; j < i + 1; j++) {
                int data = nCr(i, j);
                System.out.print(data + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 14;
        pascalTriangle(n);
        List<List<Integer>> result = generate(n);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
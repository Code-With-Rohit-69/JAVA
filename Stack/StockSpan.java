import java.util.Stack;

public class StockSpan {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> stack = new Stack<>();

        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currStock = stocks[i];

            while (!stack.isEmpty() && currStock > stocks[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                int idx = stack.peek();
                span[i] = i - idx;
            }
            
            stack.push(i);
        }

    }

    public static void main(String[] args) {

        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];

        stockSpan(stocks, span);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

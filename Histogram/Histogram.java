import java.util.Stack;

public class Histogram {
 
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};

        int n = arr.length;

        int nsr[] = new int[n];
        int nsl[] = new int[n];

        // next smaller right

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        // next smaller left

        stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, (width * arr[i]));
        }

        System.err.println(maxArea);

    }
 }
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // int arr[] = { 6, 8, 0, 1, 3 };
        // int arr[] = { 1, 2, 1 };
        int arr[] = { 1, 2, 3, 4, 3 };

        int n = arr.length;

        int nextGreater[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int currElem = arr[i];

            while (!stack.isEmpty() && currElem > arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }

            stack.push(i);

        }

        // for (int i = 0; i < arr.length; i++) {
        // int elem = -1;
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[i] < arr[j]) {
        // elem = arr[j];
        // break;
        // }
        // }

        // arr[i] = elem;
        // }

        // printing

        for (int i : nextGreater) {
            System.out.print(i + " ");
        }

    }
}

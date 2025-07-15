public class PlusOne {

    public static int[] plusOne(int digits[]) {
        int n = digits.length;
        int lastindex = n - 1;

        for (int i = lastindex; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int ans[] = new int[n + 1];
        ans[0] = 1;

        return ans;

    }

    public static void main(String[] args) {
        int arr[] = { 9, 9 };
        int result[] = plusOne(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

public class PlusOne {

    public static int[] plusOne(int arr[]) {
        int n = arr.length;
        int lastIndex = arr.length - 1;

        for (int i = lastIndex; i >= 0; i--) {
            if (i < 9) {
                arr[i] += 1;
                return arr;
            } else {
                arr[i] = 0;
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

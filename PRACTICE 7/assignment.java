public class assignment {
    public static boolean isDuplicate(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void profit(int arr[]) {
        int smaller = Integer.MAX_VALUE;
        int minIndex = -1;
        int larger = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smaller) {
                smaller = arr[i];
                minIndex = i;
            }

        }
        for (int j = minIndex + 1; j < arr.length; j++) {
            if (arr[j] > larger) {
                larger = arr[j];
            }
        }
        System.out.println("Maximum Profit = " + (larger - smaller));
    }

    public static void main(String[] args) {
        int prices[] = { 7, 6, 4, 3, 1 };
        profit(prices);
    }
}

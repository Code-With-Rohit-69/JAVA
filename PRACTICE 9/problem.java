public class problem {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int maxSolution = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // for (int j2 = 0; j2 < arr.length; j2++) {
                //     for (int k = 0; k < arr.length; k++) {
                //         System.out.print(arr[i] + arr[j] + arr[j2] + arr[k] + "  ");
                //     }
                //     System.out.println();

                // }
                System.out.print((arr[i]) + " " + (arr[j]));
            }
            // System.out.println();
        }
    }
}

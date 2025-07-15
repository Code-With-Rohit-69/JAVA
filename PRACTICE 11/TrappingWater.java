public class TrappingWater {

    public static void trappedWater(int arr[]) {
        if (arr.length > 2) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    break;
                }
                
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 4, 2, 0, 6, 3, 2, 5 };

        trappedWater(arr);
    }
}
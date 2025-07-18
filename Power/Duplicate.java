import java.util.Arrays;

public class Duplicate {

    public static boolean containsDuplicate(int arr[]) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(arr));
    }
}

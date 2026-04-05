import java.util.Arrays;

public class Vehicle {

    public static void main(String[] args) {
        // int[] size = { 20, 20, 15, 10, 5 }; 
        Integer[] size = { 10, 20, 30, 40 }; 
        // int[] size = { 30, 30, 30 }; 
        int capacity = 50; 

        Arrays.sort(size, (a, b) -> b - a);

        int n = size.length;
        int sum = 0;    
        int count = 0;

        for(int i = 0; i < n; i++) {
            int num = size[i];

            sum += num;

            if(sum > capacity) {
                sum = num;
                count++;
            }
        }

        if(sum > 0) count++;

        System.out.println(count);

    }
}

// if we are given a list of vehicles with their sizes and a capacity, how can we determine the minimum number of vehicles needed to transport all the items without exceeding the capacity?
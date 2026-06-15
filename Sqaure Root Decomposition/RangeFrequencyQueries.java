import java.util.HashMap;

public class RangeFrequencyQueries {

    public static void main(String[] args) {
        // int[] arr = { 12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56 };
        // int[][] queries = { { 1, 2, 4 }, { 0, 11, 33 } };

        int[] arr = {1,1,1,2,2};
        int[][] queries = {
            {0, 1, 2},
            {0, 2, 1},
            {3, 3, 2},
            {2, 2, 1},
        };

        RangeFreqQuery obj1 = new RangeFreqQuery(arr);

        for (int[] q : queries) {
            int res = obj1.query(q[0], q[1], q[2]);
            System.out.println(res);
        }

    }
}

class RangeFreqQuery {
    int[] arr;
    int n;
    int blockSize;
    HashMap<Integer, Integer>[] mapArr;

    @SuppressWarnings("unchecked")
    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.blockSize = (int) Math.ceil((double) Math.sqrt(n));
        this.mapArr = new HashMap[blockSize];

        for (int i = 0; i < blockSize; i++) {
            mapArr[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockSize;
            mapArr[blockIndex].put(arr[i], mapArr[blockIndex].getOrDefault(arr[i], 0) + 1);
        }

        // System.out.println("Block are " + blockSize);

        // for (HashMap<Integer, Integer> map : mapArr) {
        //     System.out.println(map);
        // }

    }
    
    public int query(int left, int right, int value) {
        
        int leftBlock = left / blockSize;
        int rightBlock = right / blockSize;

        // System.out.println("leftBlock: " + leftBlock + " " + "rightBlock: " + rightBlock);
        
        if (leftBlock == rightBlock) {
            int count = 0 ;

            for (int i = left; i <= right; i++) {
                count += arr[i] == value ? 1 : 0;
            }

            return count;
        }

        int count = 0;

        // partial left

        int leftEnd = Math.min(n - 1, (leftBlock + 1) * blockSize - 1);

        for (int i = left; i <= leftEnd; i++) {
            count += arr[i] == value ? 1 : 0;
        }

        // block

        for (int d = leftBlock + 1; d < rightBlock; d++) {
            count += mapArr[d].getOrDefault(value, 0);
        }

        // partial right

        int rightStart = rightBlock * blockSize;

        for (int i = rightStart; i <= right; i++) {
            count += arr[i] == value ? 1 : 0;
        }

        return count;
    }
}


/*

text = "aaabcabcdabcabcabcd";
pattern = "abcabcd";

*/
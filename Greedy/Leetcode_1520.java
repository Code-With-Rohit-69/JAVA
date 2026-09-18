import java.util.*;

/**
 * Leetcode_1520
 */
public class Leetcode_1520 {

    public static void main(String[] args) {
        
        Solution solution = new Solution();

        String s = "adefaddaccc";
        List<String> ans = solution.maxNumOfSubstrings(s);

        System.out.println(ans);
    }
}

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];

        Arrays.fill(firstOccur, -1);

        for(int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';

            if (firstOccur[index] == -1) {
                firstOccur[index] = i;
            }
            lastOccur[index] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            if(firstOccur[i] == -1) continue;

            int first = firstOccur[i];
            int last = lastOccur[i];

            boolean valid = true;

            for(int j = first; j <= last; j++) {
                int index = s.charAt(j) - 'a';

                if(firstOccur[index] < first) {
                    valid = false;
                    break;
                }

                last = Math.max(last, lastOccur[index]);
            }

            if(valid) {
                intervals.add(new int[] {first, last});
            }
        }

        Collections.sort(intervals, (a, b) -> {
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } 

            return Integer.compare(b[0], a[0]);
        });

        List<String> ans = new ArrayList<>();

        int prevIndex = -1;

        for(int[] interval : intervals) {
            int first = interval[0], last = interval[1];

            if (first > prevIndex) {
                ans.add(s.substring(first, last + 1));
                prevIndex = last;
            }
        }

        return ans;

    }
}
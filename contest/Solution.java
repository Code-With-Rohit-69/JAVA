import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // add element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // contribute to sum only once
            if (freq.get(nums[right]) == 1) {
                sum += nums[right];
            }

            // shrink window
            while (sum >= k) {
                ans = Math.min(ans, right - left + 1);

                freq.put(nums[left], freq.get(nums[left]) - 1);

                // remove contribution only when last occurrence is gone
                if (freq.get(nums[left]) == 0) {
                    sum -= nums[left];
                    freq.remove(nums[left]);
                }

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static String largestNumber(String s) {
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return s.substring(0, i + 1);
            }
        }

        return "";

    }

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();

        int n = words.length;

        for(int i = 0; i < n; i++) { // top
            String top = words[i];

            for(int j = 0; j < n; j++) { // left

                if(i == j) continue;
                
                String left = words[j];

                if(top.charAt(0) != left.charAt(0)) continue;

                for(int k = 0; k < n; k++) { // right
                    if(k == j || k == i) continue;

                    String right = words[k];

                    if(top.charAt(3) != right.charAt(0)) continue;

                    for(int l = 0; l < n; l++) {
                        if(l == j || l == i || l == k) continue;

                        String bottom = words[l];
    
                        if(bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)) {
                            result.add(Arrays.asList(top, left, right, bottom));
                        }
                    }
                }
            }
            
        }

        result.sort((a, b) -> {
            for(int i = 0; i < 4; i++) {
                int compare = a.get(i).compareTo(b.get(i));
                if(compare != 0) {
                    return compare;
                }
            }


            return 0;
        });
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = { "able", "area", "echo", "also" };
        System.out.println(wordSquares(words));

    }
}
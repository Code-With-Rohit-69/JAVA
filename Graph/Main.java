public class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        
        int INF = 1e9;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = INF;
        
        for (int i = 0; i < n; i++) {
            int[] nextDp = new int[2];
            nextDp[0] = INF;
            nextDp[1] = INF;
            
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            for (int carry = 0; carry <= 1; carry++) {
                if (dp[carry] == INF) continue;
                
                int baseCost = dp[carry];
                char effectiveC1 = c1;
                
                if (carry == 1) {
                    if (c1 == '0') {
                        baseCost += 1; 
                    }
                    effectiveC1 = '0';
                }
                
                for (int nextCarry = 0; nextCarry <= 1; nextCarry++) {
                    int currentCost = baseCost;
                    char finalC1 = effectiveC1;
                    
                    if (nextCarry == 1) {
                        currentCost += 1; 
                        if (finalC1 == '0') {
                            currentCost += 1;
                        }
                        finalC1 = '0';
                    }
                    
                    if (finalC1 == c2) {
                        nextDp[nextCarry] = Math.min(nextDp[nextCarry], currentCost);
                    } else if (finalC1 == '0' && c2 == '1') {
                        nextDp[nextCarry] = Math.min(nextDp[nextCarry], currentCost + 1);
                    }
                }
            }
            dp = nextDp;
        }
        
        return dp[0] >= INF ? -1 : dp[0];
    }
}
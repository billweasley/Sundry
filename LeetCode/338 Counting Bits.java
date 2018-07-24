class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        // dp[i] = dp[i / 2] + (i % 2);
        // dp[i] ：how many digits for number i
        for(int i = 0 ; i < dp.length; i++) dp[i] = dp[(i >>> 1)] + (i & 1);
        return dp;
    }
}
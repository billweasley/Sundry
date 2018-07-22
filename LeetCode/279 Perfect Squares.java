class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}
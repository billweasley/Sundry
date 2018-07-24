class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // sum(P) - sum(N) = S
        // sum(P) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N)
        // 2sum(P) = S + sum (All)
        // sum(P) = ((S + sum(All)) / 2
        // where P is the set of all positive values, N is the set of all negative values.
        int sum = 0;
        for(int val: nums) sum += val;
        if(S > sum || ((S - sum) & 1) == 1) return 0;
        if(S == sum) return 1;

        // find how many ways to make up positive set
        int target = (S + sum) >>> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int val: nums){
            for(int i = target; i - val >= 0; i--){
                dp[i] = dp[i] + dp[i - val] ;
            }
        }


        return dp[target];
    }
}
class Solution {
    public int rob(int[] nums) {
        /*if(nums.length < 1) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1],  dp[i - 1]);
        }
        return dp[nums.length];*/

        // 空间优化
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];

        int untilPrevPrevHouse = 0;
        int untilPrevHouse = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = Math.max(untilPrevPrevHouse + nums[i], untilPrevHouse);
            untilPrevPrevHouse = untilPrevHouse;
            untilPrevHouse = temp;
        }

        return Math.max(untilPrevPrevHouse, untilPrevHouse);
    }
}
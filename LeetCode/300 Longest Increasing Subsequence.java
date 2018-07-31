class Solution {
    // O(nlogn), only suit for finding length
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxIndex = -1;
        dp[0] = nums[0];
        for(int num: nums){
            int pos = binarySearch(dp, num, 0, maxIndex);
            dp[pos] = num;
            if (pos == maxIndex + 1) maxIndex += 1;
        }
        return maxIndex + 1;
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        int mid = 0;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
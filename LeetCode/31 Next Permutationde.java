class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                int val = nums[i];
                int minIndex = i + 1;
                for (int j = i + 1; j < nums.length; j++){
                    if (nums[j] > val && nums[j] < nums[minIndex]) minIndex = j;
                }
                nums[i] = nums[minIndex];
                nums[minIndex] = val;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        reverse(nums);
    }

    public static void reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;

        while( left < right ) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }
}
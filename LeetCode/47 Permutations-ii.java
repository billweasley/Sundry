class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> initial = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used, initial, res);
        return res;
    }

    private void backTrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res){
        if (current.size() == nums.length){
            res.add(new LinkedList(current));
            return;
        }
        for (int j = 0; j < nums.length; j++){
            if (used[j]) continue; //当前已用，不能接着用
            if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) continue; //前一个重复的用了
            used[j] = true;
            current.add(nums[j]);
            backTrack(nums, used, current, res);
            current.remove(current.size() - 1);
            used[j] = false;
        }

    }


}
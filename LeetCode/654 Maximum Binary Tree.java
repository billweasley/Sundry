/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int left, int right){
        if (left > right) return null;
        int maxIndex = left;
        for(int i = left ; i <= right; i++){
            if(nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = recursive(nums, left, maxIndex - 1);
        root.right = recursive(nums, maxIndex + 1, right);
        return root;
    }
}
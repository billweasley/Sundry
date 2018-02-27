
/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root.left != null) res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        if(root.right != null) res.addAll(inorderTraversal(root.right));
        return res;
    }
}
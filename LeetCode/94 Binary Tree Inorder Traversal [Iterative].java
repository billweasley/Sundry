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

 Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        while(iter != null || !stack.isEmpty()){
            while(iter != null){
                stack.push(iter); //Notice HERE! ADD CURRENT!
                iter = iter.left;
            }
            iter = stack.pop();
            res.add(iter.val);
            iter = iter.right;

        }
        return res;
    }
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]
 Return the following binary tree:

    3
  / \
 9  20
   /  \
  15   7

 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) return null;
        return builder(0,inorder.length-1,inorder,0,postorder.length -1,postorder);
    }

    private TreeNode builder(int inLow, int inHigh, int[] inorder, int posLow, int posHigh, int[] postorder){
        if(inLow > inHigh || posLow > posHigh) return null;
        TreeNode root = new TreeNode(postorder[posHigh]);
        int rootIndex = -1;
        for(rootIndex = inLow; rootIndex<= inHigh; rootIndex++){
            if(inorder[rootIndex] == root.val) break;
        }

        int leftLength = rootIndex - inLow;
        root.left = builder(inLow,rootIndex-1,inorder,posLow,posLow+leftLength-1,postorder);
        root.right = builder(rootIndex+1,inHigh,inorder,posLow + leftLength,posHigh - 1,postorder);
        return root;

    }

}
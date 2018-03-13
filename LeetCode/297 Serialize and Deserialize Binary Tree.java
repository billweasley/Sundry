/**
 *Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "N";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if(current == null){
                sb.append("N").append(" ");
            }else{
                sb.append(current.val).append(" ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        //System.out.println(sb.toString());
        sb.setLength(sb.length() - 1);
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("\\s+");
        if(strs.length == 0 || strs[0] == "N") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root);

        for(int i=1; i< strs.length;i++){
            TreeNode parent = queue.remove();
            if(!strs[i].equals("N")){
                parent.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.add(parent.left);
            }
            if(!strs[++i].equals("N")){
                parent.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.add(parent.right);

            }

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
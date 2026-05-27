/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        while(root!=null){
            if(root.left==null){
                root = root.right;
                continue;
            }
            TreeNode right = root.right;
            root.right = root.left;
            TreeNode p = pre(root.left);
            if(p!=null) p.right = right;
            root.left = null;
            root = root.right;
        }

    }
    TreeNode pre(TreeNode root){
        if(root==null) return null;
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
}
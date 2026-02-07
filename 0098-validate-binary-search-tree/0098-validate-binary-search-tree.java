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
    long prev = Long.MIN_VALUE;
    boolean notBinary = true;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        inorder(root);
        return notBinary;
    }
    void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(prev>=root.val){
            notBinary = false;
            return;
        }
        prev = root.val;
        inorder(root.right);
    }
}

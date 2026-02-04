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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        boolean[] ans = new boolean[1];
        ans[0] = true;
        balance(root,ans);
        return ans[0];
    }
    int balance(TreeNode root,boolean[] ans){
        if(root==null) return 0;

        int l = balance(root.left,ans);
        int r = balance(root.right,ans);

        if(Math.abs(r-l)>1){
            ans[0]= false;
        }

        return 1+Math.max(l,r);

    }   
}
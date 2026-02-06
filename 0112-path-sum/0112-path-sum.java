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
    int sum =0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
           return false;
        }

        if(root.left==null && root.right==null){
            if(sum+root.val==targetSum) return true;
            else return false;
        }

        sum+=root.val;

        boolean l = hasPathSum(root.left,targetSum);
        boolean r = hasPathSum(root.right,targetSum);
        
        sum-=root.val;

        return l || r;

    }

}
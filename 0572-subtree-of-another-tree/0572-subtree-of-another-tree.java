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
    boolean found = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null){
            return true;
        }
        if(root.val==subRoot.val){
            found = true;
            return check(root,subRoot);
        }
        
        return isSubtree(root.left,subRoot) && isSubtree(root.right,subRoot) && found;

    }
    boolean check(TreeNode root,TreeNode sub){
        if(root==null && sub==null){
            return true;
        }
        if(root==null || sub==null){
            return false;
        }
        
        return check(root.left,sub.left) && check(root.right,sub.right);
    }
}
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean a = false;
            boolean b = false;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.remove();
                if((curr.left!=null && curr.right!=null) && ((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x)) ){
                    return false;
                }
                if(curr.val==x){
                    a = true;
                } else if(curr.val==y){
                    b = true;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
            }
            if(a && b) return true;
        }
        return false;
    }
}
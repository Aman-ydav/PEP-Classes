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
    StringBuilder sb = new StringBuilder("");
    StringBuilder s = new StringBuilder("");
    public int sumRootToLeaf(TreeNode root) {
        sum(root);
        System.out.print(sb);
        int ans =0;
        for(int i=0;i<sb.length()-1;i++){
            int currsum =0;
            int x=0;
            while(sb.charAt(i)!='-'){
                // System.out.print(sb.charAt(i)+" ");
                currsum += (int) Math.pow(2,x++)*(sb.charAt(i)-48);
                // System.out.print(currsum+ " ");
                i++;
            }
            // System.out.print(currsum+ " ");
            // System.out.println();
            ans+=currsum;
        }
        return ans;
    }
    void sum(TreeNode root){

        if(root==null) return;
        s.append(root.val);

        if(root.left==null && root.right==null){
            sb.append(s.reverse());
            sb.append("-");
            s.reverse();
            s.setLength(s.length()-1);
            return;
        }
        sum(root.left);
        sum(root.right);
        s.setLength(s.length()-1); 
    }
    
}
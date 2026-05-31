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
    public TreeNode bstFromPreorder(int[] preorder) {
        return pre(preorder,0,preorder.length-1);
    }
    TreeNode pre(int[] preorder,int st,int ed){
        if(st>ed) return null;
        int rootval = preorder[st];
        TreeNode root = new TreeNode(rootval);
        if(st==ed) return root;
        int newSt = -1;
        for(int i=st+1;i<=ed;i++){
            if(rootval<preorder[i]){
                newSt = i;
                break;
            }
        }
        if(newSt==-1){
            root.left = pre(preorder,st+1,ed);
        }
        else{
            root.left = pre(preorder,st+1,newSt-1);
            root.right = pre(preorder,newSt,ed);
        }
        return root;
    }
}
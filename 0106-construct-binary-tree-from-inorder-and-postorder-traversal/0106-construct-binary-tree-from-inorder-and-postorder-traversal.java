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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(postorder,0,n-1,inorder,0,n-1,map);
    }
    TreeNode build(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){

        if(postStart>postEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootidx = map.get(postorder[postEnd]);
        int rightlength = inEnd - rootidx;

        root.left = build(postorder,postStart,postEnd-rightlength-1,inorder,inStart, rootidx-1,map);
        root.right = build(postorder,postEnd-rightlength, postEnd -1,inorder, rootidx+1,inEnd ,map);

        return root;
    }
}
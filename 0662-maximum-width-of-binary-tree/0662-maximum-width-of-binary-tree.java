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
    class Pair{
        TreeNode node;
        int p;
        public Pair(TreeNode node,int p){
            this.node = node;
            this.p = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){

            int n = q.size();
            int a = Integer.MIN_VALUE;
            int b = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                Pair pa = q.remove();
                a = Math.max(a,pa.p);
                b = Math.min(b,pa.p);
                if(pa.node.left!=null){
                    q.add(new Pair(pa.node.left,2*pa.p+1));
                }
                if(pa.node.right!=null){
                    q.add(new Pair(pa.node.right,2*pa.p+2));
                }
            }
            max = Math.max(max,a-b+1);
        }
        return max;
    }
}
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        long kthSum =0;
        ArrayList<Long> arr = new ArrayList<>();
        int level = 0;
        while(!q.isEmpty()){
            long sum = 0;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.remove();
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            arr.add(sum);
            level++;
        }
        Collections.sort(arr);
        if(level<k) return -1;
        // System.out.print(level);
        return arr.get(level-k);
    }
}
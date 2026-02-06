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
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        dfs(root,0L,map,targetSum);
        return count;
    }
    void dfs(TreeNode root,long currsum,HashMap<Long,Integer> map,int k){
        if(root==null) return;

        currsum += root.val;

        if(map.containsKey(currsum-k)){
            count+=map.get(currsum-k);
        }

        map.put(currsum,map.getOrDefault(currsum,0)+1);

        dfs(root.left,currsum,map,k);

        dfs(root.right,currsum,map,k);

        map.put(currsum,map.get(currsum)-1);
        if(map.get(currsum)==0) map.remove(currsum);

    }
}
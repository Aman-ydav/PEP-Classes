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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean swap = false;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                l.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(swap){
                int i=0;
                int j = l.size()-1;
                while(i<=j){
                    int temp = l.get(i);
                    l.set(i,l.get(j));
                    l.set(j,temp);
                    j--;
                    i++;
                }
            }
        
            swap = !swap;
            list.add(l);
        }
        return list;
    }
}
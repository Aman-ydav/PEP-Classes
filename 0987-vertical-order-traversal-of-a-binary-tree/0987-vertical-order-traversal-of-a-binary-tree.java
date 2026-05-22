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
    class Point{
        TreeNode node;
        int row;
        int col;
        public Point(TreeNode node,int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,List<Point>> map = new HashMap<>();
        q.add(new Point(root,0,0));
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                Point pt = q.remove();
                min = Math.min(min,pt.col);
                max = Math.max(max,pt.col);
                if(map.containsKey(pt.col)){
                    map.get(pt.col).add(pt);  
                    Collections.sort(map.get(pt.col),(a,b)->{ 
                        if(a.row==b.row){
                           return a.node.val-b.node.val;
                        }
                        return a.row-b.row;
                    });
                }
                else{
                    List<Point> l = new ArrayList<>();
                    l.add(pt);
                    map.put(pt.col,l);
                }
                if(pt.node.left!=null){
                    q.add(new Point(pt.node.left,pt.row+1,pt.col-1));
                }
                if(pt.node.right!=null){
                    q.add(new Point(pt.node.right,pt.row+1,pt.col+1));
                }
            }
        }
        for(int i=min;i<=max;i++){
            List<Point> l = map.get(i);
            List<Integer> lt = new ArrayList<>();
            for(int j=0;j<l.size();j++){
                lt.add(l.get(j).node.val);
            }
            list.add(lt);
        }
        return list;
    }
}
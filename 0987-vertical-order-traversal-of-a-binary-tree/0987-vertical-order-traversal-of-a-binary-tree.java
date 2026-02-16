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
// class Solution {
//     class View{
//         TreeNode node;
//         int hd;
//         int row;
//         public View(TreeNode node,int hd,int row){
//             this.node = node;
//             this.hd = hd;
//             this.row=row;
//         }
//     }
//      List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         Queue<View> q = new LinkedList<>();
//         int min=0,max=0;
//         Map<Integer,ArrayList<Integer>> map = new HashMap<>();
//         q.add(new View(root,0,0));
//         while(!q.isEmpty()){
//             View curr = q.remove();
//             if(map.containsKey(curr.hd)){
                
//                 map.get(curr.hd).add(curr.node.val);
//             }
//             else{
//                 ArrayList<Integer> l = new ArrayList<>();
//                 l.add(curr.node.val);
//                 map.put(curr.hd,l);
//             }
            
//             if(curr.node.left!=null){
//                 q.add(new View(curr.node.left,curr.hd-1, curr.row+1));
//                 min = Math.min(min,curr.hd-1);
//             }
//             if(curr.node.right!=null){
//                 q.add(new View(curr.node.right,curr.hd+1, curr.row + 1));
//                 max = Math.max(max,curr.hd+1);
//             }
//         }

//         for(int i=min;i<=max;i++){
//             list.add(map.get(i));
//         }
        
//         return list;
//     }
// }

class Solution {
    class View {
        TreeNode node;
        int hd;
        int row;
        public View(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<View> q = new LinkedList<>();
        int min = 0, max = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();

        q.add(new View(root, 0, 0));
        while (!q.isEmpty()) {
            View curr = q.remove();
            map.computeIfAbsent(curr.hd, k -> new ArrayList<>())
                .add(new int[]{curr.row, curr.node.val});

            if (curr.node.left != null) {
                q.add(new View(curr.node.left, curr.hd - 1, curr.row + 1));
                min = Math.min(min, curr.hd - 1);
            }
            if (curr.node.right != null) {
                q.add(new View(curr.node.right, curr.hd + 1, curr.row + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            List<int[]> nodes = map.get(i);
            nodes.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];  // sort by row
                return a[1] - b[1];                    // sort by value
            });

            List<Integer> col = new ArrayList<>();
            for (int[] n : nodes) {
                col.add(n[1]);
            }
            list.add(col);
        }

        return list;
    }
}

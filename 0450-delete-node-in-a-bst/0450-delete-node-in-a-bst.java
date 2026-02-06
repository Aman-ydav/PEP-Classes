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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode r = dfs(root,key);
        return r;
    }
    TreeNode dfs(TreeNode root,int key){
        if(root==null) return null;

        if(root.val==key){
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            TreeNode su = succ(root.right);
            System.out.print(su.val);
            root.val = su.val;
            root.right = dfs(root.right,su.val);

        }

        else if(root.val>key){
            root.left = dfs(root.left,key);
        }
        else if(root.val<key){
            root.right =   dfs(root.right,key);
        }
        return root;

    }
    TreeNode succ(TreeNode root){
        if(root==null) return null;

        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
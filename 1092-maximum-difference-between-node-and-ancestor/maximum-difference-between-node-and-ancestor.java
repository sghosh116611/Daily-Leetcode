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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        
        f(root,root.val,root.val);

        return ans;

    }

    public void f(TreeNode root, int max, int min){
        
        if(root == null){
            ans = Math.max(ans,max - min);
            return;
        }
            
        
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);

        f(root.left,max,min);
        f(root.right,max,min);
    }
}
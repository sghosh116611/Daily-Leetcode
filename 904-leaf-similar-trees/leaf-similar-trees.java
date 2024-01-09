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
    int count;
    ArrayList<Integer> leafs = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        f1(root1);
        for(Integer leaf : leafs)
            System.out.println(leaf);
         System.out.println(count);
        return f2(root2) && count == leafs.size();
    }

    public void f1(TreeNode root){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            leafs.add(root.val);
        
        f1(root.left);
        f1(root.right);
    }

    public boolean f2(TreeNode root){
        if(root.left == null && root.right == null){
            count++;
            if(count > leafs.size())
                return false;
            if(leafs.get(count - 1) != root.val)
                return false;
            else
                return true;
        }

        boolean left = false, right = false;
        if(root.right == null)
            return f2(root.left);
        else if(root.left == null)
            return f2(root.right);
        else return f2(root.left) && f2(root.right);
        
    }
}
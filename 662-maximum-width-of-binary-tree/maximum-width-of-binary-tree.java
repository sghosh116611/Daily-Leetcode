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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode,Integer> map = new HashMap<TreeNode, Integer>();

        queue.offer(root);
        map.put(root,1);

        int max = 0;
        int diff = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(i == 0) start = map.get(currentNode);
                if(i == size - 1) end = map.get(currentNode);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                    map.put(currentNode.left,map.get(currentNode) * 2);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                    map.put(currentNode.right,map.get(currentNode) * 2 + 1);
                }
            }
            
            diff = end - start + 1;
            max = Math.max(max,diff);
        }

        return max;

        // if(root == null) return 0;
        // Queue<TreeNode> q = new LinkedList<TreeNode>();
        // Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        // q.offer(root);
        // m.put(root, 1);
        // int curW = 0;
        // int maxW = 0;
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     int start = 0;
        //     int end = 0;
        //     for(int i = 0; i < size; i++){
        //         TreeNode node = q.poll();
        //         if(i == 0) start = m.get(node);
        //         if(i == size - 1) end = m.get(node);
        //         if(node.left != null){
        //             m.put(node.left, m.get(node) * 2);
        //             q.offer(node.left);
        //         }
        //         if(node.right != null){
        //             m.put(node.right, m.get(node) * 2 + 1);
        //             q.offer(node.right);
        //         }
        //     }
        //     curW = end - start + 1;
        //     maxW = Math.max(curW, maxW);
        // }
        // return maxW;
    }
}
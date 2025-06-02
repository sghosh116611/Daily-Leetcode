/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        
        // code here
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> hdMap = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        queue.offer(new Pair(root,0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node currentNode = pair.node;
            int currentHd = pair.hd;
            
            if(!hdMap.containsKey(currentHd)){
                hdMap.put(currentHd,currentNode.data);
            }
            
            if(currentNode.left != null) queue.offer(new Pair(currentNode.left,currentHd - 1));
            if(currentNode.right != null) queue.offer(new Pair(currentNode.right,currentHd + 1));
            
        }
        
        for(int data : hdMap.values()){
            result.add(data);
        }
        
        return result;
        
    }
    
    static class Pair{
        Node node;
        int hd;
        
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
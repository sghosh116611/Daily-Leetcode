class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hdMap = new TreeMap<>();
        
        queue.offer(new Pair(root,0));
        
        while(!queue.isEmpty()){
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int currentHd = currentPair.hd;
            
            
            hdMap.put(currentHd,currentNode.data);
            
            
            if(currentNode.left != null) queue.offer(new Pair(currentNode.left,currentHd - 1));
            if(currentNode.right != null) queue.offer(new Pair(currentNode.right,currentHd + 1));
        }
        
        for (int val : hdMap.values()) {
            result.add(val);
        }
        
        return result;
    }
    
    class Pair{
        Node node;
        int hd;
    
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
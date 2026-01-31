class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
         }
        
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(detectCycle(i,adj,visited))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,-1));
        visited[src] = true;
        
        while(!queue.isEmpty()) {
            Pair polledNode = queue.poll();
            int node = polledNode.first;
            int parent = polledNode.second;
            
            for(int nei : adj.get(node)) {
                if(!visited[nei]) {
                    queue.add(new Pair(nei,node));
                    visited[nei] = true;
                } else {
                    if(parent != nei)
                        return true;
                }
            }
        }
        return false;
    }
}

class Pair {
    int first;
    int second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
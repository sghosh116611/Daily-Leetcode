class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                result.add(bfs(i,adj,visited));
            }
        }
        return result;
    }
    
    public ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            res.add(vertex);
            for(int neighbour : adj.get(vertex)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return res;
    }
}
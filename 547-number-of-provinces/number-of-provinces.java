class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                bfs(i,isConnected,visited);
                count++;
            }
        }

        return count;
    }

    private void bfs(int start, int[][] isConnected, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei = 0; nei < isConnected.length; nei++) {
                if (isConnected[node][nei] == 1 && !isVisited[nei]) {
                    queue.add(nei);
                    isVisited[nei] = true;
                }
            }
        }
    }
}
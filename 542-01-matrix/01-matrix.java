class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<Tri> queue = new LinkedList<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Tri(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            Tri tri = queue.poll();
            int i1 = tri.i;
            int j1 = tri.j;
            int step = tri.step;
            dist[i1][j1] = step;

            int[][] trav = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int k = 0; k <= 3; k++) {
                int i2 = i1 + trav[k][0];
                int j2 = j1 + trav[k][1];

                if(i2 >= 0 && i2 < m && j2 >= 0 && j2 < n 
                && mat[i2][j2] == 1) {
                    if(!visited[i2][j2]) {
                        visited[i2][j2] = true;
                        queue.add(new Tri(i2,j2,step + 1));
                    }
                }
            }
        }

        return dist;
    }
}

class Tri {
    int i;
    int j;
    int step;

    Tri(int i, int j, int step) {
        this.i = i;
        this.j = j;
        this.step = step;
    }
}
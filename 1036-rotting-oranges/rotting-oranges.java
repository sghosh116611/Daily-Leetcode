class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0, min = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i,j));
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int trav[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            int level = queue.size();
            while(level-- != 0) {
                Pair pop = queue.poll();
                int i = pop.x;
                int j = pop.y;

                for(int tra[] : trav) {
                    int x = i + tra[0];
                    int y = j + tra[1];

                    if(x >= 0 && x < m && y >= 0 && y < n &&
                        grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new Pair(x,y));
                        fresh--;
                    }
                }
            }
            min++;
        }

        return fresh == 0 ? min - 1 : -1;
    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i,j));
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int mins = 0;
        System.out.println(fresh);

        if(fresh == 0) return 0;

        while(!queue.isEmpty()) {
            int level = queue.size();
            while(level-- > 0) {
                Pair rottenNode = queue.poll();
                int i = rottenNode.i;
                int j = rottenNode.j;

                int[][] trav = {{0,1},{0,-1},{-1,0},{1,0}};

                for(int k = 0; k <= 3; k++) {
                    int i1 = i + trav[k][0];
                    int j1 = j + trav[k][1];
                    if(i1 >= 0 && i1 < m && j1 >= 0 && j1 < n
                        && grid[i1][j1] == 1) {
                        queue.add(new Pair(i1,j1));
                        grid[i1][j1] = 2;
                        fresh--;
                    }
                }
            }
            mins++;
        }

        System.out.println(fresh);
        return fresh == 0 ? mins -1 : -1;
    }
}

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
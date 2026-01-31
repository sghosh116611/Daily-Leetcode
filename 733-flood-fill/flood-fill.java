class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int ogColor = image[sr][sc];

        if(ogColor == color) return image;
        
        queue.add(new Pair(sr,sc));
        image[sr][sc] = color;

        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            int i1 = node.i;
            int j1 = node.j;

            int[][] trav = {{0,1}, {0,-1}, {-1,0},{1,0}};

            for(int k = 0; k <= 3; k++) {
                int i2 = i1 + trav[k][0];
                int j2 = j1 + trav[k][1];

                if(i2 >= 0 && i2 < m && j2 >= 0 && j2 < n
                    && image[i2][j2] == ogColor) {
                        image[i2][j2] = color;
                        queue.add(new Pair(i2,j2));
                    }
            }
        }

        return image;
    }
}

class Pair {
    int i ;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
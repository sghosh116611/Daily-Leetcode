class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sp = image[sr][sc];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr,sc));
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] idxArr = {{0,-1},{0,1},{-1,0},{1,0}};


        while(!queue.isEmpty()){
            Point point = queue.poll();
            int i = point.i;
            int j = point.j;
            visited[i][j] = true;
            image[i][j] = color;

            for(int[] idx : idxArr){
                if(i + idx[0] < image.length && i + idx[0] >= 0
                    && j + idx[1] < image[0].length && j + idx[1] >= 0
                    && !visited[i + idx[0]][j + idx[1]]
                    && image[i + idx[0]][j + idx[1]] == sp
                ){
                    queue.offer(new Point(i + idx[0],j + idx[1]));
                }
            }
        }

        return image;
    }
}

class Point{
    int i;
    int j;

    Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
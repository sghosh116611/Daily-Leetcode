//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        ArrayList<String> result = new ArrayList<>();
        
        if(mat[0][0] == 0)
            return result;
        fn(0,0,mat,visited,n,new StringBuilder(),result);
        
        return result;
        
    }
    
    public void fn(int row, int col, int[][] mat, boolean[][] visited, int n, StringBuilder path, List<String> result){
        
        //System.out.println(row + " " + col);
        if(row == n - 1 && col == n - 1){
            result.add(path.toString());
            return;
        }
        
        // Traverse right
        if(col + 1 < n && mat[row][col + 1] != 0 && !visited[row][col + 1]){
            path.append("R");
            visited[row][col + 1] = true;
            fn(row,col + 1, mat, visited,n,path,result);
            visited[row][col + 1] = false;
            path.deleteCharAt(path.length() - 1);
        }
        
        // Traverse left
        if(col - 1 >= 0 && mat[row][col - 1] != 0 && !visited[row][col - 1]){
            path.append("L");
            visited[row][col - 1] = true;
            fn(row,col - 1, mat, visited,n,path,result);
            visited[row][col - 1] = false;
            path.deleteCharAt(path.length() - 1);
        }
        
        // Traverse down
        if(row + 1 < n && mat[row + 1][col] != 0 && !visited[row + 1][col]){
            path.append("D");
            visited[row + 1][col] = true;
            fn(row + 1,col, mat, visited,n,path,result);
            visited[row + 1][col] = false;
            path.deleteCharAt(path.length() - 1);
        }
        
        // Traverse up
        if(row - 1 >= 0 && mat[row - 1][col] != 0 && !visited[row - 1][col]){
            path.append("U");
            visited[row - 1][col] = true;
            fn(row - 1,col, mat, visited,n,path,result);
            visited[row - 1][col] = false;
            path.deleteCharAt(path.length() - 1);
        }
        
    }
}
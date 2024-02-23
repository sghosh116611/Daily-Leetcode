class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freq = new int[n + 1];

        if(n == 1 && trust.length == 0)   
            return 1;

        for(int[] x:trust){
            freq[x[0]]--;
            freq[x[1]]++;
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == n - 1) {
                return i;
            }
                
        }

        return -1;
    }
}
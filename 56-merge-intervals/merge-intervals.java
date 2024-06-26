class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();

        int[] mergedInterval = intervals[0];
        result.add(mergedInterval);

        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] <= mergedInterval[1]){
                mergedInterval[1] = Math.max(mergedInterval[1],interval[1]);
            }else{
                
                mergedInterval = interval;
                result.add(mergedInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
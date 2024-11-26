class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int merged[] = intervals[0];
        result.add(merged);
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] <= merged[1]){
                int x = Math.min(merged[0], interval[0]);
                int y = Math.max(merged[1], interval[1]);
                System.out.println(x + " " + y);
                merged[0] = x;
                merged[1] = y;
            }else{
                merged = interval;
                result.add(merged);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
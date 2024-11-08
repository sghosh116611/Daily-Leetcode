class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            queue.add(num);
        }

        int res = Integer.MAX_VALUE;
        while(k-- > 0)
            res = queue.poll();
        
        return res;
    }
}
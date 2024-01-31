class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                System.out.println(idx);
                ans[idx] = i - idx;
            }
            stack.push(i);
        }

        return ans;
    }
}
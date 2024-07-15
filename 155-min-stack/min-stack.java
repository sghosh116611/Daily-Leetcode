class MinStack {
    Long min;
    Stack<Long> stack;
    public MinStack() {
        min = Long.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(stack.isEmpty()){
            min = Long.valueOf(val);
            stack.push(val);
        }
        else{
            if(val < min){
                stack.push(2 * val - min);
                min = Long.valueOf(val);
            }
            else
                stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        Long top = stack.pop();

        if(top < min){
            min = 2 * min - top;
        }
    }
    
    public int top() {
        Long top = stack.peek();
        if(top < min)
            return min.intValue();
        return top.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long absN = Math.abs((long)n); 

        while (absN != 0) {
            if ((absN & 1) != 0) 
                result *= x; 
            x *= x;           
            absN >>= 1;       
        }

        return n < 0 ? 1 / result : result;
    }
}
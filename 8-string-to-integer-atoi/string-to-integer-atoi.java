class Solution {
    public int myAtoi(String s) {
        // Trim the string to remove leading and trailing whitespace
        s = s.trim();

        // Check for empty string
        if(s.length() == 0)
            return 0;

        // Check for positive or negative in front
        boolean isNegative = false; int startingIdx = 0;
        if(s.charAt(0) == '-')
            isNegative = true;
        if(isNegative || s.charAt(0) == '+')
            startingIdx = 1;

        int intVal = 0;
        boolean isLeadingZero = true;

        for(int i = startingIdx; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))
                break;
            
            int digit = s.charAt(i) - '0';

            // Overflow check BEFORE adding the digit
            if (intVal > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            intVal = intVal * 10 + digit;
        }

        if(isNegative){
            intVal *= -1;
        }
        return intVal;
    }
}
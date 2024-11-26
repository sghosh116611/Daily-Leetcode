class Solution {
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {

        if(num == 0) return "Zero";
        
        int i = 0;
        String words = "";
        while(num > 0){
            int rem = num % 1000;
            if(rem != 0){
                words = fn(rem) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();  
    }

    private String fn(int num){
        if(num == 0) return "";

        if(num < 20){
            return LESS_THAN_20[num] + " ";
        }else if(num < 100){
            return TENS[num / 10] + " " + fn(num % 10);
        }else{
            return LESS_THAN_20[num / 100] + " Hundred " + fn(num % 100);
        }
    }
}
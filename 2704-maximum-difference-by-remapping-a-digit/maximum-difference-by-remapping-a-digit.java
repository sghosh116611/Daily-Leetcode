class Solution {
    public int minMaxDifference(int num) {
        
        String num1 = String.valueOf(num);
        String num2 = String.valueOf(num);

        // Maximum value
        char d1 = Character.MIN_VALUE;
        for(int i = 0; i < num1.length(); i++){
            char ch = num1.charAt(i);
            if(ch != '9'){
                d1 = ch;
                break;
            }
        }
        num1 = num1.replace(d1,'9');

        // Min value
        char d2 = Character.MIN_VALUE;
        for(int i = 0; i < num2.length(); i++){
            char ch = num2.charAt(i);
            if(ch != '0'){
                d2 = ch;
                break;
            }
        }
        num2 = num2.replace(d2,'0');
        System.out.println(num1 + " " + num2);

        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }
}
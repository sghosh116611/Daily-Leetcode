class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else{
            String digit = countAndSay(n - 1);
            return rle(digit);
        }
    }

    private String rle(String s){
        String res = "";
        int i = 0;
        while(i < s.length()){
            int count = 1;
            char ch = s.charAt(i);
            while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                i++;
                count++;
            }
            res += count + "" + ch;
            i++;
        }
        System.out.println(res);
        return res;
    }
}
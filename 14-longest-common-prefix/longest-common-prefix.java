class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int idx1 = 0, idx2 = 0;
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        String res = "";
        while(idx1 < s1.length() && idx2 < s2.length()){
            if(s1.charAt(idx1) == s2.charAt(idx2)){
                res += s1.charAt(idx1);
                idx1++;
                idx2++;
            }
            else{
                break;
            }
        }

        return res;
    }
}
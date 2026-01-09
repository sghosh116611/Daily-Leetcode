class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int l = 0, r = l + 1, len = 1, res = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l),0);

        while(l < r && r < s.length()) {
            char ch = s.charAt(r);
            if(map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }
            map.put(ch,r);
            len = r - l + 1;
            res = Math.max(len,res);
            r++;
            System.out.println("L=" + l + " R="+ r + " Len=" + len);
        }
        return res;
    }
}
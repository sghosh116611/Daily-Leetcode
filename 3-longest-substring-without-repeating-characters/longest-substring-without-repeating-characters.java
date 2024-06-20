class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int pos = 0, max = 0;
        if(s.length() == 0)
            return 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                pos = Math.max(map.get(ch) + 1, pos);
            }
            map.put(ch,i);
            System.out.println(i + " " + pos);
            max = Math.max(max,i - pos + 1);
        }

        return max;
    }
}
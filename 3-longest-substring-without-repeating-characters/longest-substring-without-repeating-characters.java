class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                pos = Math.max(pos,map.get(ch) + 1);
                map.put(ch,i);
            }
            map.put(ch,i);
            System.out.println(pos);
            max = Math.max(i - pos + 1,max);
        }

        return max;
    }
}
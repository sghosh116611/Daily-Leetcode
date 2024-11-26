class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        int start = 0, length = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                //System.out.println(i + " " + start);
                map.put(ch,i);
            }else{
                start = Math.max(map.get(ch) + 1,start);
                map.put(ch,i);
            }
            
            length = i - start + 1;

            result = Math.max(result,length);
        }

        return result;
    }
}
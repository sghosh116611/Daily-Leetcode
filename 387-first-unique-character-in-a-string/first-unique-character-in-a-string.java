class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < s.length(); i++)
            if(freq[s.charAt(i) - 'a'] == 1)
            {
                res = i;
                break;
            }
        return res;
    }
}
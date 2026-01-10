class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3], count = 0;
        freq[0] = -1; freq[1] = -1; freq[2] = -1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a'] = i;

            count += Math.min(Math.min(freq[0],freq[1]),freq[2]) + 1;
        }

        return count;
    }
}
class Solution {
    public boolean halvesAreAlike(String s) {
        int c1 = 0, c2 = 0;
        for(int i = 0; i < s.length() / 2; i++){
            if(isVowel(s.charAt(i)))
                c1++;
            if(isVowel(s.charAt(s.length() - 1 - i)))
                c2++;
        }
        return c1 == c2;
    }

    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        
        return false;
    }
}
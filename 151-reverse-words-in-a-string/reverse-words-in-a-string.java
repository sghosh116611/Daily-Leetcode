class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String rev = "";
        for(String word : words){
            System.out.println(word);
            if(word.trim().length() != 0)
                rev =  word + " " + rev;
        }

        return rev.trim();
    }
}
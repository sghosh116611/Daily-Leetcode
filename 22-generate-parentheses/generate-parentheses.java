class Solution {
    
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        func(0,0,"",n,"");

        return result;
    }

    public void func( int open, int close, String ch,int n, String s){
        s += ch;

        if(open + close == 2 * n){
            result.add(s);
            return;
        }


        if(open != n){
            func(open + 1, close, "(",n,s);
        }

        if(close < open){
            func(open, close + 1, ")",n,s);
        }
    }
}
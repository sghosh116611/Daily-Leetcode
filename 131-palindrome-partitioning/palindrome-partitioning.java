class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        func(s,0,res,new ArrayList<>(),"");
        return res;
    }

    private void func(String s, int idx, List<List<String>> res, List<String> ds, String tempStr) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }
            

        for(int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(isPalindrome(s.substring(idx,i + 1))) {
                ds.add(s.substring(idx,i + 1));
                func(s,i + 1, res, ds, tempStr);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        String revString = new StringBuilder(s).reverse().toString();
        return s.equals(revString);
    }
}
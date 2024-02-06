class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String sortedString = sortString(strs[i]);
            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<String>());
            }
            map.get(sortedString).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> ele:map.entrySet()){
            ans.add(ele.getValue());
        }
        return ans;
    }

    public String sortString(String s){
        char word[] = s.toCharArray();
        Arrays.sort(word);
        return String.valueOf(word);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str : strs){
            String sortedStr = sortWord(str);
            if(map.containsKey(sortedStr)){
                List<String> row = map.get(sortedStr);
                row.add(str);
            }else{
                List<String> words = new ArrayList<>();
                words.add(str);
                map.put(sortedStr, words);
            }
        }

        for (Map.Entry<String,List<String>> ele : map.entrySet()) {
            result.add(ele.getValue());
        }

        return result;
    }

    private String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
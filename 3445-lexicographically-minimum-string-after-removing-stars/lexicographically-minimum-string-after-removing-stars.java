class Solution {
    public String clearStars(String s) {
        List<List<Integer>> bucketOfIndex = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            bucketOfIndex.add(new ArrayList<>());
        }

        boolean[] removed = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                removed[i] = true;
                for(int j = 0; j < 26; j++){
                    if(!bucketOfIndex.get(j).isEmpty()){
                        removed[bucketOfIndex.get(j).get(bucketOfIndex.get(j).size() - 1)] = true;
                        bucketOfIndex.get(j).remove(bucketOfIndex.get(j).size() - 1);
                        break;
                    }
                }
            }else{
                bucketOfIndex.get(ch - 'a').add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!removed[i])
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
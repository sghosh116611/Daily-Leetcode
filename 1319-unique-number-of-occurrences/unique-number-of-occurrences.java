class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n: arr){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(set.contains(entry.getValue()))
                return false;
            set.add(entry.getValue());
        }
        return true;
    }
}
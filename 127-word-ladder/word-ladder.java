class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            String originalStr = current.str;
            int currentLevel = current.lvl;

            if(originalStr.equals(endWord)) return currentLevel;

            for(int i = 0; i < originalStr.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    String newWord = originalStr.substring(0,i) 
                    + ch + originalStr.substring(i + 1);
                    if(set.contains(newWord)) {
                        queue.add(new Pair(newWord,currentLevel + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}

class Pair {
    String str;
    int lvl;

    Pair(String str, int lvl) {
        this.str = str;
        this.lvl = lvl;
    }
}
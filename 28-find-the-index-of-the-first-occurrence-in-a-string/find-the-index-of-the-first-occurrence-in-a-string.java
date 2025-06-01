class Solution {
    public int strStr(String haystack, String needle) {
        // int n = haystack.length();
        // int m = needle.length();
        // for(int i = 0; i <= n - m; i++){
        //     if(haystack.charAt(i) == needle.charAt(0)){
        //         if(haystack.substring(i,i+m).equals(needle)){
        //             return i;
        //         }
        //     }
        // }
        // return -1;
        return kmpAlgorithm(haystack,needle);
    }

    private int kmpAlgorithm(String s, String pattern){
        int[] piTable = constructPITable(pattern);
        int i = 0, j = 0;
        while(i < s.length()){
            if(s.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j > 0)
                    j = piTable[j];
                else
                    i++;
            }
            if(j == pattern.length()){
                return i - j;
            }
        }
        return -1;
    }

    private int[] constructPITable(String s){
        int[] piTable = new int[s.length() + 1];

        int i = 1,  j = 0;
        while(i < s.length()){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = piTable[j];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            piTable[i + 1] = j;
            i++;
        }
        return piTable;
    }
}
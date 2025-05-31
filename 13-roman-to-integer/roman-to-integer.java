class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int intVal = 0;
            if(ch == 'I'){
                if(i != s.length() - 1){
                    char ch1 = s.charAt(i + 1);
                    if(ch1 == 'V' || ch1 == 'X'){
                        intVal = map.get(ch1) - map.get(ch);
                        i++;
                    }else
                        intVal = map.get(ch);
                }else
                    intVal = map.get(ch);
            }else if(ch == 'X'){
                if(i != s.length() - 1){
                    char ch1 = s.charAt(i + 1);
                    if(ch1 == 'L' || ch1 == 'C'){
                        intVal = map.get(ch1) - map.get(ch);
                        i++;
                    }else
                        intVal = map.get(ch);
                }else
                    intVal = map.get(ch);
            }else if(ch == 'C'){
                if(i != s.length() - 1){
                    char ch1 = s.charAt(i + 1);
                    if(ch1 == 'D' || ch1 == 'M'){
                        intVal = map.get(ch1) - map.get(ch);
                        i++;
                    }else
                        intVal = map.get(ch);
                }else
                    intVal = map.get(ch);
            }else{
                intVal = map.get(ch);
            }
            System.out.println(intVal);
            res += intVal;
        }

        return res;
    }
}
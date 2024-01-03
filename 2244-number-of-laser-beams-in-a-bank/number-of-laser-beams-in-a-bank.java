class Solution {
    public int numberOfBeams(String[] bank) {
        int total = 0;
        int prevRowDevice = 0;
        for(int i = 0; i < bank.length; i++){
            int rowDevice = 0;
            for(int j = 0; j < bank[i].length(); j++){
                if(bank[i].charAt(j) == '1')
                    rowDevice++;
            }
            if(prevRowDevice == 0){
                prevRowDevice = rowDevice;
            } else if(rowDevice != 0 ){
                total += prevRowDevice * rowDevice;
                prevRowDevice = rowDevice;
            }
                
        }
        return total;
    }
}
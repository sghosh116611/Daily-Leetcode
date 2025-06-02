class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy,1);

        for(int i = 1; i < n; i++){
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : candy[i];
        }

        for(int c:candy){
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println();
        for(int i = n - 2; i >= 0; i--){
            candy[i] = ratings[i] > ratings[i + 1] ? Math.max(candy[i],candy[i + 1] + 1) 
            : candy[i];
        }

        for(int c:candy){
            System.out.print(c + " ");
        }
        System.out.println();

        int res = 0;
        for(int c : candy){
            res += c;
        }

        return res;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int w) {
        // code here
        int n = values.size();
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++){
            Item item = new Item();
            item.weight = weights.get(i);
            item.value = values.get(i);
            items[i] = item;
        }
        Arrays.sort(items, (Item i1, Item i2) -> Double.compare((double) i2.value / i2.weight, (double) i1.value / i1.weight));
        
        double totalValue = 0, totalWeight = w;
        for(int i = 0; i < n; i++){
            if(totalWeight > 0){
                Item item = items[i];
                if(item.weight < totalWeight){
                    totalValue += item.value;
                    totalWeight -= item.weight;
                }else{
                    totalValue += ((double)item.value / (double)item.weight) * (double)totalWeight;
                    totalWeight = 0;
                }
            }else{
                break;
            }
        }
        return totalValue;
    }
    
    private class Item{
        public int weight;
        public int value;
    }
}
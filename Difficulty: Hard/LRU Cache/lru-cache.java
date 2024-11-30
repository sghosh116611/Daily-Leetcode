//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    int size;
    HashMap<Integer,Integer> cache;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        size = cap;
        cache = new LinkedHashMap<>();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        int value = cache.getOrDefault(key,-1);
        if(value != -1){
          this.set(key,value);
        }
        return value;
        
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        // your code here
        if(cache.size() == size && !cache.containsKey(key)){
            int delKey = cache.keySet().iterator().next();
            cache.remove(delKey);
        }else if(cache.containsKey(key)){
            cache.remove(key);
        }
        
        cache.put(key,value);
    }
}

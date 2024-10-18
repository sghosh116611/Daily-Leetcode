//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        Meeting meetings[] = new Meeting[n];
        int count = 1;
        for(int i = 0; i < n; i++){
            Meeting meeting = new Meeting();
            meeting.start = start[i];
            meeting.end = end[i];
            meetings[i] = meeting;
        }
        
        Arrays.sort(meetings, (Meeting m1, Meeting m2) -> {
            return m1.end - m2.end;
        });
        
        int meetingEnd = meetings[0].end;
        for(int i = 1; i < n; i++){
            if(meetingEnd < meetings[i].start){
                meetingEnd = meetings[i].end;
                count++;
            }
        }
        
        return count;
    }
    
    private class Meeting{
        public int start;
        public int end;
    }
}

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        Meeting[] meetings = new Meeting[start.length];
        for(int i = 0; i < start.length; i++){
            Meeting meeting = new Meeting(start[i],end[i]);
            meetings[i] = meeting;
        }
        
        Arrays.sort(meetings, (Meeting m1, Meeting m2) -> m1.end - m2.end);
        
        int meetingEnd = Integer.MIN_VALUE, count = 0;
        for(Meeting meeting : meetings){
            if(meeting.start > meetingEnd){
                count++;
                meetingEnd = Math.max(meetingEnd, meeting.end);
            }
        }
        
        return count;
    }
    
}

class Meeting{
    int start;
    int end;
    
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

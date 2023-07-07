package MergeIntervals;

import java.util.Arrays;

public class MeetingRooms2 {
    public static int solve(int[][] intervals){
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0 ; i < n ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int i = 1, j = 0, current = 1;
        int answer = 1;
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                current++;
                i++;
            } else {
                current--;
                j++;
            }
            answer = Integer.max(answer, current);
        }
        return answer;
    }
}

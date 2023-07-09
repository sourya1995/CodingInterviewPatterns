package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
 
    static int n;
    static String s;
    static LinkedList<String> segments;
    static ArrayList<String> result;

    public static boolean valid(String segment){
        int m = segment.length();
        if(m > 3) return false;

        return(segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public static void updateSegment(int currDot){
        String segment = s.substring(currDot + 1, n);
        if(valid(segment)){
            segments.add(segment);
            String ip = String.join(".", segments);
            result.add(ip);
            segments.removeLast();
        }
    }

    public static void backtrack(int prevDot, int dots){
        int maxPos = Math.min(n-1, prevDot + 4);
        for(int currDot = prevDot + 1; currDot < maxPos; currDot++){
            String segment = s.substring(prevDot + 1, currDot + 1);
            if(valid(segment)){
                segments.add(segment);
                if(dots - 1 == 0)
                    updateSegment(currDot);

                else
                    backtrack(currDot, dots - 1);
                segments.removeLast();
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        result = new ArrayList<String>();
        segments = new LinkedList<String>();
        backtrack(-1, 3);
        return result;
    }
}


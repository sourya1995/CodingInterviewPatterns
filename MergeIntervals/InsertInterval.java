package MergeIntervals;

import java.util.List;

public class InsertInterval {
    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        int newStart= newInterval.getStart();
        int newEnd= newInterval.getEnd();
        int i = 0;
        int n = existingIntervals.size();
        List<Interval> output = new ArrayList<Interval>();
        while (i < n && existingIntervals.get(i).getStart() < newStart) {
            output.add(existingIntervals.get(i));
            i += 1;
        }
        if(output.size() == 0 || output.get(output.size() - 1).getEnd() < newStart){
            output.add(newInterval);
        } else {
            output.get(output.size() - 1).setEnd(Math.max(output.get(output.size() - 1).getEnd(), newEnd));
        }

        while(i < n){
            Interval ei = existingIntervals.get(i);
            int start = ei.getStart();
            int end = ei.getEnd();
            if(output.get(output.size() - 1).getEnd() < start){
                output.add(ei);
            } else {
                output.get(output.size() - 1).setEnd(Math.max(output.get(output.size() - 1).getEnd(), end));
            }
            i += 1;
        }
        return output;
    }
}

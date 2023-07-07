package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<Interval>();

        if(intervals.size() == 0){
            return result;
        }

        result.add(new Interval(intervals.get(0).getStart(), intervals.get(0).getEnd()));
        for(int i = 1; i < intervals.size(); i++){
            Interval lastAddedInterval = result.get(result.size() - 1);
            int currentStart = intervals.get(i).getStart();
            int currentEnd = intervals.get(i).getEnd();
            int previousEnd = lastAddedInterval.getEnd();
            if(currentStart <= previousEnd){
                lastAddedInterval.setEnd(Math.max(currentEnd, previousEnd));
            } else {
                result.add(new Interval(currentStart, currentEnd));
            }
    }
    return result;
}

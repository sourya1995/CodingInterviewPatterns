package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static List<Interval> intervalsIntersection(List<Interval> intervalListA, List<Interval> intervalListB) {
        List<Interval> intersections = new ArrayList<>();
        int i = 0, j = 0;
        while (i < intervalListA.size() && j < intervalListB.size()) {
            int start = Math.max(intervalListA.get(i).getStart(), intervalListB.get(j).getStart());
            int end = Math.min(intervalListA.get(i).getEnd(), intervalListB.get(j).getEnd());
            if (start <= end)
                intersections.add(new Interval(start, end));
            if (intervalListA.get(i).getEnd() < intervalListB.get(j).getEnd())
                i += 1;
            else
                j += 1;
        }
        return intersections;
    }
}

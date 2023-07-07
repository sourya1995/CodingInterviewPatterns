package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTIme {
    public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] -b[0]); //ascending priority
        for(int i = 0; i < schedule.size(); i++){
            List<Interval> employeeSchedule = schedule.get(i); //get the schedule
            Interval interval = employeeSchedule.get(0); //get first interval
            heap.offer(new int[]{interval.getStart(), i, 0}); //start of interval, index of employee, first interval of this employee
        }

        List<Interval> result = new ArrayList<>();
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).getStart();

        while(!heap.isEmpty()){
            int [] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];

            Interval interval = schedule.get(i).get(j);
            if(interval.getStart() > previous){
                result.add(new Interval(previous, interval.getStart()));
            }

            previous = Math.max(previous, interval.getEnd());

            if(j + 1 < schedule.get(i).size()){
                Interval nexInterval = schedule.get(i).get(j + 1);
                heap.offer(new int[]{nexInterval.getStart(), i, j + 1});
            }
        }

        return result;
    }
}

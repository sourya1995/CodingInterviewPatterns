package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
     public class Event{
        private int id;
        private boolean isStart;
        private int time;

        public Event(String content){
            String[] strs = content.split(":");
            this.id = Integer.valueOf(strs[0]);
            this.isStart = strs[1].equals("start");
            this.time = Integer.valueOf(strs[2]);
        }

        public int getId(){
            return this.id;
        }

        public boolean getIsStart(){
            return this.isStart;
        }

        public int getTime(){
            return this.time;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Event> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for(String content : logs){
            Event event = new Event(content);
            if(event.getIsStart()){
                stack.push(event);
            } else {
                Event top = stack.pop();
                result[top.getId()] += event.getTime() - top.getTime() + 1;

                if(!stack.isEmpty()){
                    result[stack.peek().getId()] -= event.getTime() - top.getTime() + 1;
                }
            }
        }
        return result;
    }
}

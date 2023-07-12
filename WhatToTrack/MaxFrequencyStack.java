package WhatToTrack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {
    class FreqStack {

        Map<Integer, Integer> frequency;
        Map<Integer, Stack<Integer>> group;
        int maxFrequency;

        public FreqStack() {
            frequency = new HashMap<>();
            group = new HashMap<>();
            maxFrequency = 0;
        }

        public void push(int val) {
            int freq = frequency.getOrDefault(val, 0) + 1;
            frequency.put(val, freq);
            if (freq > maxFrequency)
                maxFrequency = freq;

            group.computeIfAbsent(freq, z -> new Stack<>()).push(val);
        }

        public int pop() {
            int show = 0;
            if (maxFrequency > 0) {
                show = group.get(maxFrequency).pop();
                frequency.put(show, frequency.get(show) - 1);
                if (group.get(maxFrequency).size() == 0)
                    maxFrequency--;
            } else {
                return -1;
            }

            return show;
        }
    }

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */
}

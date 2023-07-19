package Stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            int i = 0;

            while (i < heights.length) {
                if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                    stack.push(i);
                    i++;
                } else {
                    int topIndex = stack.pop();
                    int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, area);
                }
            }

            while (!stack.isEmpty()) {
                int topIndex = stack.pop();
                int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }
    }

}

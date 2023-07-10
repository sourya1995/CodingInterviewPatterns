package Stacks;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingStack {
    class Stack {
        private List<Integer> stackList;

        public Stack() {
            stackList = new ArrayList<>();
        }

        public boolean isEmpty() {
            return stackList.isEmpty();
        }

        public int top() {
            if (isEmpty()) {
                return -1; // Assuming -1 indicates an empty stack
            }
            return stackList.get(stackList.size() - 1);
        }

        public int size() {
            return stackList.size();
        }

        public void push(int value) {
            stackList.add(value);
        }

        public int pop() {
            if (isEmpty()) {
                return -1; // Assuming -1 indicates an empty stack
            }
            int topValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return topValue;
        }
    }

    private Stack stack1;
    private Stack stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.top();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

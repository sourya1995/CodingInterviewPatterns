package Stacks;

import java.util.ArrayList;
import java.util.List;

public class MinMoveToRemoveParentheses {

    class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }

    public String minRemoveToMakeValid(String s) {
        List<Pair<Character, Integer>> stack = new ArrayList<>();
        StringBuilder sList = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!stack.isEmpty() && stack.get(stack.size() - 1).getFirst() == '(' && val == ')') {
                stack.remove(stack.size() - 1);
            }

            else if (val == '(' || val == ')') {
                stack.add(new Pair<>(val, i));
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.get(stack.size() - 1).getSecond();
            sList.deleteCharAt(index);
            stack.remove(stack.size() - 1);
        }

        return sList.toString();
    }
}

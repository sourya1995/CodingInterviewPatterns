package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class DecimalToBinary {
    private static String helper(int n){
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            int remainder = n % 2;
            stack.push(remainder);
            n >>= 1;
        }

        int[] bits = new int[stack.size()];
        int k = 0;

        while(!stack.isEmpty()) {
            bits[k++] = stack.pop();
        }

        return Arrays.toString(bits);
    }
}

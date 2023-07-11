package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNumbers {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            String[] a = new String[n];
            for (int i = 1; i <= n; i++)
                a[i - 1] = Integer.toString(i);
            Arrays.sort(a);
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++)
                ans.add(Integer.parseInt(a[i - 1]));

            return ans;

        }
    }
}

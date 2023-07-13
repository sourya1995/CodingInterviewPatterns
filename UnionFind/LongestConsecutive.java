import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    class Solution {

        class UnionFind {
            public Map<Integer, Integer> parent;
            public Map<Integer, Integer> size;
            public int maxLength;

            // Constructor
            public UnionFind(int[] nums) {
                parent = new HashMap<>();
                size = new HashMap<>();
                maxLength = 1;

                for (int num : nums) {
                    parent.put(num, num);
                    size.put(num, 1);
                }
            }

            // Function to find the root of a sequence to which num belongs
            public int find(int num) {
                if (parent.get(num) != num) {
                    parent.put(num, find(parent.get(num)));
                }
                return parent.get(num);
            }

            // Function to merge the two sequences and update lengths
            public void union(int num1, int num2) {
                int xRoot = find(num1);
                int yRoot = find(num2);
                if (xRoot != yRoot) {
                    if (size.get(xRoot) < size.get(yRoot)) {
                        int temp = xRoot;
                        xRoot = yRoot;
                        yRoot = temp;
                    }
                    parent.put(yRoot, xRoot);
                    size.put(xRoot, size.get(xRoot) + size.get(yRoot));
                    maxLength = Math.max(maxLength, size.get(xRoot));
                }
            }
        }

        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            UnionFind ds = new UnionFind(nums);
            for (int num : nums) {
                if (ds.parent.containsKey(num + 1)) {
                    ds.union(num, num + 1);
                }
            }

            return ds.maxLength;
        }
    }
}

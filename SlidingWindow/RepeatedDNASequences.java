package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
    public static Set<String> findRepeatedDNASequences(String s, int k) {
        int n = s.length();

        if (n < k) {
            return new HashSet<>();

        }

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        int a = 4;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        int hashValue = 0;
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a)
                        + numbers.get(i + k - 1); //gets the last element in current substring
            }

            if (hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            hashSet.add(hashValue);
        }
        return output;
    }
}

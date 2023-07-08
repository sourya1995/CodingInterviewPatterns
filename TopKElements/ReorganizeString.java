package TopKElements;
 import java.util.*;

public class ReorganizeString {
   

    public String reorganizeString(String s) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for(char c: s.toCharArray()){
            int freq = charCounter.getOrDefault(c, 0) + 1;
            charCounter.put(c, freq);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxFreqChar = new PriorityQueue<Map.Entry<Character, Integer>>(
            (item1, item2) -> item2.getValue() - item1.getValue());
        maxFreqChar.addAll(charCounter.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(s.length());

        while(!maxFreqChar.isEmpty() || previous != null){
            if(previous != null && maxFreqChar.isEmpty())
                return "";

            Map.Entry<Character, Integer> currentEntry = maxFreqChar.poll();
            int count = currentEntry.getValue() - 1;
            result.append(currentEntry.getKey());

            if(previous != null){
                maxFreqChar.add(previous);
                previous = null;
            }

            if(count != 0){
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);
            }
        }
        return result.toString();
    }
}


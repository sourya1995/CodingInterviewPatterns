package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class RepeatingCharacter {
    public static int longestRepeatingCharacterReplacement(String s, int k){
        int stringLength = s.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;

        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqCharacter = 0;

        for(int end =0; end < stringLength; end++){
            char currentCharacter = s.charAt(end);
            charFreq.put(currentCharacter, charFreq.getOrDefault(currentCharacter, 0) + 1);
            mostFreqCharacter = Math.max(mostFreqCharacter, charFreq.get(currentCharacter));
            if(end - start + 1 - mostFreqCharacter > k){
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start += 1;
            }
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
        }
        return lengthOfMaxSubstring;
    }
}

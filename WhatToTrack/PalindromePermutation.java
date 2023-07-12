package WhatToTrack;

import java.util.HashMap;

public class PalindromePermutation {
    public static boolean permutePalindrome(String s){
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            index += 1;
            if(frequencies.containsKey(s.charAt(i))){
                frequencies.put(s.charAt(i), frequencies.get(s.charAt(i)) + 1);
            } else{
                frequencies.put(s.charAt(i), 1);
            }
        }

        int count = 0;
        for(Character ch: frequencies.keySet()){
            if(frequencies.get(ch) % 2 != 0){
                count+= 1;
            }
        }

        if(count <= 1){
            return true;
        }
        else {
            return false;
        }
    }
}

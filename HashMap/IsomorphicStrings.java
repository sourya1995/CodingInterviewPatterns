package HashMap;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapStr1Str2 = new HashMap<Character, Character>();
        Map<Character, Character> mapStr2Str1 = new HashMap<Character, Character>();

        int i=0, j=0;

        while(i < s.length()){
            char char1 = s.charAt(i++);
            char char2 = t.charAt(j++);

            if(mapStr1Str2.containsKey(char1) && mapStr1Str2.get(char1) != char2)
                return false;
            
            if(mapStr2Str1.containsKey(char2) && mapStr2Str1.get(char2) != char1)
                return false;

            mapStr1Str2.put(char1, char2);
            mapStr2Str1.put(char2, char1);
        }

        return true;
    }
}
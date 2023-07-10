package TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AlienDictionary {
    public static String alienOrder(List<String> words){
        HashMap<Character, List<Character>> adjacencyList = new HashMap<Character, List<Character>>();
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        
        for(String word : words){
            char[] strArray = word.toCharArray();
            for(char c : strArray){
                count.put(c, 0);
            }
        }

        Set<Character> characters = count.keySet();

        for(int i = 0; i < words.size() - 1; i++){
            String word1 = words.get(i);
            String word2 = words.get(i + 1);
            int j = 0;
            for(j = 0; j < word1.length() && j < word2.length(); j++){
                char c = word1.charAt(j);
                char d = word2.charAt(j);

                if(c != d){
                    if(adjacencyList.get(c) == null){
                        adjacencyList.put(c, new ArrayList<Character>());
                    }

                    if(adjacencyList.get(d) == null){
                        adjacencyList.put(d, new ArrayList<Character>());
                    } 

                    boolean found = false;
                    for(int k = 0; k < adjacencyList.get(c).size(); k++){
                        if(adjacencyList.get(c).get(k) == d){
                            found = true;
                        }
                    }

                    if(!found){
                        adjacencyList.get(c).add(d);
                        count.put(d, count.get(d) + 1);
                    }

                    break;
                }
            }

            if(j >= word1.length() || j >= word2.length()){
                if(word2.length() < word1.length()) {
                    return "";
                }
            }
        }

        List<Character> result = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();

        for(char c: count.keySet()) {
            if(count.get(c) == 0){
                queue.add(c);
            }
        }

        int m = 0;
        while(!queue.isEmpty()){
            m += 1;
            char c = queue.removeFirst();
            result.add(c);
            if(adjacencyList.get(c) == null){
                adjacencyList.put(c, new ArrayList<>());
            }

            for(int f = 0; f < adjacencyList.get(c).size(); f++){
                char d = adjacencyList.get(c).get(f);
                n += 1;
                count.put(d, count.get(d) - 1);

                if(count.get(d) == 0){
                    queue.add(d);
                }
            }
        }

        if(result.size() < characters.size()){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(Character ch: result){
            sb.append(ch);
        }

        String output = sb.toString();
        return output;
    }
}

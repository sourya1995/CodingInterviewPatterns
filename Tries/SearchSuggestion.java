package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SearchSuggestion {
    public class Node {
    Node [] child = new Node [26];
    LinkedList<String> searchWords = new LinkedList<>();
}

    private Node root = new Node();

    public void insert(String word){
        Node node = root;
        int idx = 0;
        for(char ch: word.toCharArray()){
            idx += 1;
            int index = ch - 'a';
            if(node.child[index] == null){
                node.child[index] = new Node();
            }

            node = node.child[index];
            node.searchWords.offer(word);
            if(node.searchWords.size() > 3){
                node.searchWords.pollLast();
            }
        }
    }

    public List<List<String>> search(String searchWord){
        List<List<String>> result = new ArrayList<>();
        Node node = root;
        for(char ch: searchWord.toCharArray()){
            int index = ch - 'a';
            if(node != null){
                node = node.child[index];

            }

            result.add(node == null ? Arrays.asList() : node.searchWords);
        }
        return result;

    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String product: products){
            insert(product);
        }
        return search(searchWord);
    }
}

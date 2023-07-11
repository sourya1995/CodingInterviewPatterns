package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReplaceWords {
    class Solution {

        class Trie {

            public TrieNode root;

            // Function to insert words in the trie
            public void insertInTrie(String key) {
                TrieNode temp = root;
                for (int i = 0; i < key.length(); i++) {
                    int id = key.charAt(i) - 'a';
                    if (Objects.isNull(temp.children[id])) {
                        temp.children[id] = new TrieNode();
                    }
                    temp = temp.children[id];
                }
                temp.isEOW = true;
            }

            public String replace(String str) {
                TrieNode temp = root;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    int id = str.charAt(i) - 'a';
                    sb.append(str.charAt(i));
                    if (Objects.isNull(temp.children[id])) {
                        return str;
                    }
                    temp = temp.children[id];
                    if (temp.isEOW) {
                        return sb.toString();
                    }
                }
                return sb.toString();
            }

        }

        public class TrieNode {
            public static final int SIZE = 26;
            TrieNode[] children = new TrieNode[SIZE];
            boolean isEOW;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            trie.root = new TrieNode();

            for (String prefix : dictionary) {
                trie.insertInTrie(prefix);
            }

            List<String> sentenceList = Arrays.asList(sentence.split(" "));
            List<String> newList = new ArrayList<>();
            for (String str : sentenceList) {
                newList.add(trie.replace(str));
            }

            return String.join(" ", newList);
        }
    }

}

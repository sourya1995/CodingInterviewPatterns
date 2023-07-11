package Tries;

import java.util.*;

public class WordGame2 {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isString;

        TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isString = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        // Function to insert a string in the trie
        void insert(String stringToInsert) {
            TrieNode node = this.root;
            for (char c : stringToInsert.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isString = true;
        }

        // Function to search a string from the trie
        boolean search(String stringToSearch) {
            TrieNode node = this.root;
            for (char c : stringToSearch.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isString;
        }

        // Function to search prefix of strings
        boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return true;
        }

        // Function to delete the characters in the searched word that are not shared
        void removeCharacters(String stringToDelete) {
            TrieNode node = this.root;
            List<TrieNode> childList = new ArrayList<TrieNode>();

            for (char c : stringToDelete.toCharArray()) {
                childList.add(node);
                node = node.children.get(c);
            }

            for (int i = childList.size() - 1; i >= 0; i--) {
                TrieNode parent = childList.get(i);
                char childChar = stringToDelete.charAt(i);
                TrieNode target = parent.children.get(childChar);

                if (!target.children.isEmpty()) {
                    return;
                }
                parent.children.remove(childChar);
            }
        }
    }

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            Trie trieForWords = new Trie();
            List<String> result = new ArrayList<>();
            for (String word : words) {
                trieForWords.insert(word);

            }

            for (int j = 0; j < board.length; j++) {
                for (int i = 0; i < board[0].length; i++) {
                    dfs(trieForWords, trieForWords.root, board, j, i, result, new String());
                }
            }

            return result;
        }

        private static void dfs(Trie wordsTrie, TrieNode node, char[][] board, int row, int col, List<String> result,
                String word) {
            if (node.isString) {
                result.add(word);
                node.isString = false;
                wordsTrie.removeCharacters(word);
            }

            if (0 <= row && row < board.length && 0 <= col && col < board[0].length) {
                char c = board[row][col];
                TrieNode child = node.children.get(c);
                if (child != null) {
                    String newWord = word + c;
                    board[row][col] = 0;
                    for (int[] offset : Arrays.asList(new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 },
                            new int[] { -1, 0 })) {
                        dfs(wordsTrie, child, board, row + offset[0], col + offset[1], result, newWord);
                    }
                    // Restoring state after exploration
                    board[row][col] = c;
                }
            }
        }
    }
}

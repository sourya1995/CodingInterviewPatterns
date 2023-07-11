package Tries;

import java.util.*;

class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trieNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trieNode.children.containsKey(c)) {
                trieNode.children.put(c, new TrieNode());
            }

            trieNode = trieNode.children.get(c);
        }

        trieNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode trieNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trieNode.children.containsKey(c)) {
                return false;
            }

            trieNode = trieNode.children.get(c);
        }
        return trieNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!trieNode.children.containsKey(c)) {
                return false;
            } else
                trieNode = trieNode.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

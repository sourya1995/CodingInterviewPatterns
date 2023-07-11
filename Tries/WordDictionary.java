package Tries;

class WordDictionary {
    public class TrieNode {
        // Empty list of child nodes
        public TrieNode[] children;
        public boolean complete;

        public TrieNode() {
            // Create 26 child nodes for each letter of alphabet
            children = new TrieNode[26];
            // False indicates this node is not the end of a word
            complete = false;
        }
    }

    TrieNode root;
    boolean canFind;

    public WordDictionary() {
        root = new TrieNode();
        canFind = false;
    }

    public List<String> getWords() {
        List<String> wordsList = new ArrayList<String>();
        if (root == null)
            return new ArrayList<String>();
        return DFS(root, "", wordsList);
    }

    private List<String> DFS(TrieNode node, String word, List<String> wordsList) {
        if (node == null)
            return wordsList;
        if (node.complete) {
            wordsList.add(word);
        }

        for (int j = (int) 'a'; j <= (int) 'z'; j++) {
            String prefix = word + (char) j;
            wordsList = DFS(node.children[j - 'a'], prefix.toString(), wordsList);
        }

        return wordsList;
    }

    public void addWord(String word) {
        int n = word.length();
        TrieNode curNode = root;
        for (int i = 0; i < n; i++) {
            int index = (int) (word.charAt(i) - 'a');
            if (curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];

            if (i == n - 1) {
                if (curNode.complete == true) {
                    return;
                }
                curNode.complete = true;
            }
        }
    }

    public boolean search(String word) {
        canFind = false;
        searchHelper(root, word, 0);
        return canFind;
    }

    private void searchHelper(TrieNode node, String word, int i) {
        if (canFind)
            return;
        if (node == null)
            return;

        int n = word.length();
        if (n == i) {
            if (node.complete) {
                canFind = true;
            }
            return;
        }
        if (word.charAt(i) == '.') {
            for (int j = (int) 'a'; j <= (int) 'z'; j++) {
                searchHelper(node.children[(char) j - 'a'], word, i + 1);
            }
        } else {
            int index = word.charAt(i) - 'a';
            searchHelper(node.children[index], word, i + 1);

        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

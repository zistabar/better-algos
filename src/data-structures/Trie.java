public class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int charIdx = ch - 'a';

            if (node.children[charIdx] == null) {
                node.children[charIdx] = new TrieNode();
            }
            node = node.children[charIdx];
        }
        node.isCompleteWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int charIdx = ch - 'a';

            if (node.children[charIdx] == null) {
                return false;
            }
            node = node.children[charIdx];
        }
        return node.isCompleteWord;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            int charIdx = ch - 'a';

            if (node.children[charIdx] == null) {
                return false;
            }
            node = node.children[charIdx];
        }
        return true;
    }
}

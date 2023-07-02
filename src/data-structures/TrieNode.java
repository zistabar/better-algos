public class TrieNode {

    TrieNode[] children;
    boolean isCompleteWord;

    TrieNode() {
        children = new TrieNode[26];
    }
}

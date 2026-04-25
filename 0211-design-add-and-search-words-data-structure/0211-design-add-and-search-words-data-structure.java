public class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new WordDictionary();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int index, WordDictionary node) {
        if (index == word.length()) return node.isEnd;

        char c = word.charAt(index);

        if (c == '.') {
            for (WordDictionary child : node.children) {
                if (child != null && dfs(word, index + 1, child)) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            return dfs(word, index + 1, node.children[idx]);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad")); 
        System.out.println(wordDictionary.search(".ad")); 
        System.out.println(wordDictionary.search("b..")); 
    }
}
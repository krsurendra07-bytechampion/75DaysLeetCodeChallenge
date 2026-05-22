class Solution {
    static class TrieNode {
        TrieNode[] ch = new TrieNode[26];
        String word;
    }

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode n = root;
            for (char c : w.toCharArray())
                n = (n.ch[c-'a'] == null ? n.ch[c-'a'] = new TrieNode() : n.ch[c-'a']);
            n.word = w;
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, res);
        return res;
    }

    void dfs(char[][] b, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length) return;
        char ch = b[r][c];
        if (ch == '#' || node.ch[ch-'a'] == null) return;
        node = node.ch[ch-'a'];
        if (node.word != null) { res.add(node.word); node.word = null; }
        b[r][c] = '#';
        for (int[] d : dirs) dfs(b, r+d[0], c+d[1], node, res);
        b[r][c] = ch;
    }
}
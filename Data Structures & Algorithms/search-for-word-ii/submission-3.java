class Node {
    Node[] child;
    boolean eow;
    String word;          // Stores the complete word

    Node() {
        child = new Node[26];
        eow = false;
        word = null;
    }
}

class Solution {

    Node root = new Node();
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words)
            insert(word);

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (curr.child[index] == null)
                curr.child[index] = new Node();

            curr = curr.child[index];
        }

        curr.eow = true;
        curr.word = word;
    }

    public void dfs(char[][] board, int i, int j, Node curr) {

        // Boundary check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        // Already visited?
        if (board[i][j] == '#')
            return;

        char ch = board[i][j];
        int index = ch - 'a';

        // Prefix doesn't exist in Trie
        if (curr.child[index] == null)
            return;

        // Move Trie pointer
        curr = curr.child[index];

        // Found a word
        if (curr.eow) {
            ans.add(curr.word);

            // Prevent duplicates
            curr.eow = false;
        }

        // Mark visited
        board[i][j] = '#';

        // Explore all four directions
        dfs(board, i + 1, j, curr);
        dfs(board, i - 1, j, curr);
        dfs(board, i, j + 1, curr);
        dfs(board, i, j - 1, curr);

        // Restore board
        board[i][j] = ch;
    }
}
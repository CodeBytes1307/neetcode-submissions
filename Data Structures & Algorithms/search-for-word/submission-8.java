class Solution {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(backtrack(board, i, j, word, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int index, boolean[][] visited)
    {
        // Out of bounds
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        // Already visited
        if(visited[i][j])
            return false;

        // Character doesn't match
        if(board[i][j] != word.charAt(index))
            return false;

        // Entire word matched
        if(index == word.length() - 1)
            return true;

        // Choose
        visited[i][j] = true;

        // Explore
        boolean found =
                backtrack(board, i + 1, j, word, index + 1, visited) ||
                backtrack(board, i - 1, j, word, index + 1, visited) ||
                backtrack(board, i, j + 1, word, index + 1, visited) ||
                backtrack(board, i, j - 1, word, index + 1, visited);

        // Undo
        visited[i][j] = false;

        return found;
    }
}
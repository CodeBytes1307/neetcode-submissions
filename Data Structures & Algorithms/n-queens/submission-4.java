class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }

        nqueen(board, 0);
        return ans;
    }

    private void nqueen(char[][] board, int row)
    {
        int n = board.length;
        if(row == n)
        {
            List<String> l = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++)
                {
                    sb.append(board[i][j]);
                }
                l.add(sb.toString());
            }
            ans.add(l);
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(isSafe(board,row,i))
            {
                board[row][i] = 'Q';
                nqueen(board,row+1);
                board[row][i] = '.'; //backtracking
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col)
    {
        int n = board.length;

        //row
        for(int i = 0; i < n; i++)
        {
            if(board[row][i] == 'Q') return false;
        }

        //col
        for(int i = 0; i < n; i++)
        {
            if(board[i][col] == 'Q') return false;
        }

        int i = row;
        int j = col;
        //NE
        while(i>=0 && j<n)
        {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row;
        j = col;

        //SE
        while(i<n && j<n)
        {
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        i = row;
        j = col;

        //SW
        while(i<n && j>=0)
        {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        i = row;
        j = col;

        //NW
        while(i>=0 && j>=0)
        {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }
}

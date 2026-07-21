class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,"",n);
        return ans;
    }

    private void backtrack(int open, int close, String curr, int n)
    {
        if(open == n && close == n)
        {
            if(!ans.contains(curr))
                ans.add(curr);
            return;
        }

        if(open < n)
        {
            backtrack(open + 1, close, curr + "(", n); 
        }
        if(close < open)
        {
            backtrack(open, close + 1, curr + ")", n);
        }
    }
}

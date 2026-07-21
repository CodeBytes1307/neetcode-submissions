class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, new ArrayList<>(), 0);
        return ans;
    }
    private void backtrack(String s, List<String> curr, int start)
    {
        if(start == s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end < s.length(); end++)
        {
            String temp = s.substring(start, end + 1);
            String reversed = new StringBuilder(temp).reverse().toString();
            if(temp.equals(reversed))
            {
                curr.add(temp);
                backtrack(s, curr, end+1);
                curr.remove(curr.size() - 1);
            }
                
        }

    }
}

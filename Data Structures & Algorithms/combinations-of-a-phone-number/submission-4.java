class Solution {
    List<String> ans = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return ans;
            
        backtrack(digits, "", 0);
        return ans;
    }
    private void backtrack(String digits, String curr, int index)
    {
        if(index == digits.length()){
            ans.add(curr);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];
        for(int i = 0; i < letters.length(); i++)
        {
            char ch = letters.charAt(i);
            backtrack(digits, curr + ch, index + 1);
        }
    }
}

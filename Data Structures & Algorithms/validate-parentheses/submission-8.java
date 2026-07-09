class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0)
        {
            return false;
        }
        
        int flag = 0;

        Stack <Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '('|| ch == '{' || ch == '[')
            {
                st.push(ch);
                flag = 1;
            }
            else if(!st.isEmpty() && ((ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '[')))
            {
                st.pop();
            }
            else
            {
                return false;
            }
        }

        if(st.isEmpty() && flag == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

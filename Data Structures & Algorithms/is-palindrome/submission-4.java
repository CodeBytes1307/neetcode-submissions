class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i<=j)
        {
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(j));
            System.out.println(ch1 + " " + ch2);

            if(!Character.isLetterOrDigit(ch1))
            {
                i++;
            }
            else if(!Character.isLetterOrDigit(ch2))
            {
                j--;
            }

            else if(ch1 == ch2)
            {
                
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}

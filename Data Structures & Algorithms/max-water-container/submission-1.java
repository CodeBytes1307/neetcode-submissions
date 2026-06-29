class Solution {
    public int maxArea(int[] heights) {
        int area = 0, len = 0, breadth = 0, i = 0, j = heights.length - 1;

        while(i<j)
        {
            len = Math.min(heights[i],heights[j]);
            breadth = j-i;
            
            int max = len* breadth;

            if(max > area)
            {
                area = max;
            }

            else if(heights[i] < heights[j])
            {
                i++;
            }

            else{
                j--;
            }
        }

        return area;
    }
}

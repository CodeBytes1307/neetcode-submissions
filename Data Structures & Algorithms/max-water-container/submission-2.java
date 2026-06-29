class Solution {
    public int maxArea(int[] heights) {
        int area = 0, i = 0, j = heights.length - 1;

        while(i<j)
        {
            int max = Math.min(heights[i],heights[j])* (j-i);

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

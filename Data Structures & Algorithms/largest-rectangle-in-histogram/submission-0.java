class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() &&
                   currHeight < heights[st.peek()]) {

                int h = heights[st.pop()];

                int leftSmaller =
                        st.isEmpty() ? -1 : st.peek();

                int width = i - leftSmaller - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}
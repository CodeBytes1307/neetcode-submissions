class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        int left = 0 , right = cols-1;

        for(int i = 0; i < rows; i++)
        {
            if(target > matrix[i][right])
            {
                continue;
            }
            else{
                while(left<=right)
                {
                    int mid = (left+right)/2;
                    if(matrix[i][mid] == target)
                    {
                        return true;
                    }
                    else if(matrix[i][mid] > target)
                    {
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
            }

            left = 0;
            right = cols - 1;
        }

        return false;
    }
}

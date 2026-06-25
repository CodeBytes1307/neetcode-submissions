class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zero = 0;
        int len = nums.length;

        for (int i = 0; i<len; i++)
        {
            if(nums[i] == 0)
            {
                zero++;
                if(zero>1)
                {
                    return new int[len];
                }
                continue;
            }
            product*=nums[i];
        }

        int[] result = new int[len];

        for(int i = 0; i < len; i++)
        {
            if(zero == 1 && nums[i] != 0)
            {
                result[i] = 0;
            } else if(nums[i] != 0){
                result[i] = product/nums[i];
            }
            else{
                result[i] = product;
            }
        }

        return result;
    }
}  

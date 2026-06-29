class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }

        int len = nums.length, result = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<len; i++)
        {
            if(!list.contains(nums[i]))
            {
                list.add(nums[i]);
            }
        }

        Collections.sort(list);
        int max = 0;

        for(int i = 0; i < list.size()-1; i++)
        {
            if(list.get(i) == list.get(i+1)-1)
            {
                max++;
            }
            else{
                result = Math.max(result, max);
                max = 0;
            }
        }

        if(max > result)
        {
            result = max;
        }

        return result+1;
    }
}

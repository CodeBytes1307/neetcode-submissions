class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return ans;
    }
    public void backtrack(int[] nums, int index)
    {
        int n = nums.length;
        if(index == n)
        {
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }

        for(int i = index; i < n; i++)
        {
            swap(i, index, nums);
            backtrack(nums,index+1);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

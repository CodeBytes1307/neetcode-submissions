class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, nums, target, new ArrayList<>());
        return ans;
    }
    public void backtrack(int index, int[] nums, int target, List<Integer> curr)
    {
        if(index == nums.length)
            return;

        if(target == sum)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(sum > target)
            return;

        // Take
        curr.add(nums[index]);
        sum+= nums[index];
        backtrack(index, nums, target, curr);

        // Undo
        sum -= curr.remove(curr.size() - 1);

        // Don't Take
        backtrack(index + 1, nums, target, curr);
    }
}

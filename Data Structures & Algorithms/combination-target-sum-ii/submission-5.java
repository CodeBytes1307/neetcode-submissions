class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);          // Sort to handle duplicates
        backtrack(0, candidates, target, new ArrayList<>());

        return ans;
    }

    private void backtrack(int index, int[] nums, int target, List<Integer> curr)
    {
        // Found a valid combination
        if(target == 0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < nums.length; i++)
        {
            // Skip duplicates at the same level
            if(i > index && nums[i] == nums[i - 1])
                continue;

            // Since array is sorted, no need to continue
            if(nums[i] > target)
                break;

            // Take
            curr.add(nums[i]);

            backtrack(i + 1, nums, target - nums[i], curr);

            // Undo
            curr.remove(curr.size() - 1);
        }
    }
}
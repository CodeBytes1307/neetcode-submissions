class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, int index, List<Integer> curr)
    {
        if(index == nums.length)
        {
            List<Integer> l = new ArrayList<>(curr);
            Collections.sort(l);
            if(!ans.contains(l))
                ans.add(l);
            return;
        }

        //Take
        curr.add(nums[index]);
        backtrack(nums, index+1, curr);

        //Undo
        curr.remove(curr.size() - 1);

        //Don't Take
        backtrack(nums, index+1, curr);
    }
}

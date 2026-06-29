class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);    // Makes duplicate handling much easier

        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < len; j++) {

                int need = -(nums[i] + nums[j]);

                if (map.containsKey(need)) {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(need);
                    list.add(nums[j]);

                    if (!result.contains(list))
                        result.add(list);
                }

                map.put(nums[j], j);
            }
        }

        return result;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left+right) / 2;

            if (nums[mid] > nums[right]) {
                // minimum is in right half
                left = mid + 1;
            } else {
                // minimum is at mid or in left half
                right = mid;
            }
        }

        return nums[left];
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            // Partition in nums1
            int cut1 = left + (right - left) / 2;

            // Partition in nums2
            int cut2 = (m + n + 1) / 2 - cut1;

            // Elements just to the left and right of the cuts
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Total length is even
                if ((m + n) % 2 == 0) {
                    int leftMax = Math.max(left1, left2);
                    int rightMin = Math.min(right1, right2);

                    return (leftMax + rightMin) / 2.0;
                }

                // Total length is odd
                return Math.max(left1, left2);
            }

            // Too many elements taken from nums1
            else if (left1 > right2) {
                right = cut1 - 1;
            }

            // Too few elements taken from nums1
            else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {3,4,5,1,2};
        System.out.println(sol.findMin(nums1)); 
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(sol.findMin(nums2)); 
        int[] nums3 = {11,13,15,17};
        System.out.println(sol.findMin(nums3)); 
    }
}
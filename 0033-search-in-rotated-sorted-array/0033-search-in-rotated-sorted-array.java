class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4,5,6,7,0,1,2};
        System.out.println(sol.search(nums1, 0)); 
        System.out.println(sol.search(nums1, 3)); 
        int[] nums2 = {1};
        System.out.println(sol.search(nums2, 0));
    }
}
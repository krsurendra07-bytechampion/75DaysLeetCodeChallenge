import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,1,1,2,2,3};
        System.out.println("Test 1: " + Arrays.toString(sol.topKFrequent(nums1, 2))); 

        int[] nums2 = {1};
        System.out.println("Test 2: " + Arrays.toString(sol.topKFrequent(nums2, 1))); 

        int[] nums3 = {1,2,1,2,1,2,3,1,3,2};
        System.out.println("Test 3: " + Arrays.toString(sol.topKFrequent(nums3, 2))); 
        

        int[] nums4 = {4,4,4,5,5,6,6,6,6,7};
        System.out.println("Test 4: " + Arrays.toString(sol.topKFrequent(nums4, 2))); 
    }
}


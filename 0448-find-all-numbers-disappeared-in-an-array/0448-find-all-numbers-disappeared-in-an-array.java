import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1]; // track presence

        // Mark numbers that appear
        for (int num : nums) {
            seen[num] = true;
        }

        // Collect missing numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                result.add(i);
            }
        }

        return result;
    }
}

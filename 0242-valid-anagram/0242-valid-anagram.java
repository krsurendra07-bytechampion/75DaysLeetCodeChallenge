public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // only lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;  // increase for s
            count[t.charAt(i) - 'a']--;  // decrease for t
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both null - identical at this point
        if (p == null && q == null) return true;

        // One null, other not - different structure
        if (p == null || q == null) return false;

        // Different values - not same
        if (p.val != q.val) return false;

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode p1 = new TreeNode(1);
        p1.left  = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left  = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Example 1: " + sol.isSameTree(p1, q1));
        
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Example 2: " + sol.isSameTree(p2, q2));
        TreeNode p3 = new TreeNode(1);
        p3.left  = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left  = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Example 3: " + sol.isSameTree(p3, q3));
        System.out.println("Example 4: " + sol.isSameTree(null, null)); 
        TreeNode p5 = new TreeNode(1);
        System.out.println("Example 5: " + sol.isSameTree(p5, null)); 
    }
}
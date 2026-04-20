
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

public class Main {
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(6);
        root.left        = new TreeNode(2);
        root.right       = new TreeNode(8);
        root.left.left   = new TreeNode(0);
        root.left.right  = new TreeNode(4);
        root.right.left  = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left  = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        Solution sol  = new Solution();

        TreeNode p = root.left;        
        TreeNode q = root.right;       
        System.out.println("LCA(2, 8) = " + sol.lowestCommonAncestor(root, p, q).val);
        p = root.left;                 
        q = root.left.right;           
        System.out.println("LCA(2, 4) = " + sol.lowestCommonAncestor(root, p, q).val);
        p = root.left.right.left;      
        q = root.left.right.right;     
        System.out.println("LCA(3, 5) = " + sol.lowestCommonAncestor(root, p, q).val);
        p = root.right.left;          
        q = root.right.right;          
        System.out.println("LCA(7, 9) = " + sol.lowestCommonAncestor(root, p, q).val);
    }
}
/**
 * 对称二叉树
 * [1 2 2 3 4 4 3] 对称
 * [1 2 2 null 3 null 3] 非对称
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return match(root.left, root.right);

    }

    private boolean match(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && match(left.left, right.right) && match(left.right, right.left);
    }
}

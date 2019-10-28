
/**
 * 路径综合
 */
public class Leetcode112 {
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (sum == root.val && root.left == null && root.right == null) {
            res = true;
        }

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}

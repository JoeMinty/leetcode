/**
 * 路径总和
 */
public class Leetcode113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, res);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> res) {

        // 終止條件
        if (root == null) {
            return;
        }

        // 處理數據
        res.add(root.val);

        if (sum == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(res) );
        }

        // dfs
        dfs(root.left, sum - root.val, res);
        dfs(root.right, sum - root.val, res);

        res.remove(res.size() - 1);
    }
}

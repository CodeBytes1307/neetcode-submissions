class Solution {
    boolean balanced = true;

    public int dfs(TreeNode root)
    {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1)
            balanced = false;

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
}
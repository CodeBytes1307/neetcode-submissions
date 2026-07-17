class Solution {
    int count = 0;
    int ans = 0;

    public void dfs(TreeNode root, int k) {
        if (root == null)
            return;

        dfs(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return;
        }

        dfs(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}
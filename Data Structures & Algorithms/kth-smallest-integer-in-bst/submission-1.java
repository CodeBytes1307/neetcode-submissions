/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode root)
    {
        if(root == null)
            return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        if(k <= list.size())
        {
            return list.get(k-1);
        }

        return 0;
    }
}

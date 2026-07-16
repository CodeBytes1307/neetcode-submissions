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
    List<Integer> ans = new ArrayList<>();

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        // First node encountered at this level
        if (level == ans.size())
            ans.add(root.val);

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // if(root == null)
        //     return ans;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty())
        // {
        //     int size = q.size();

        //     for(int i = 0; i < size; i++)
        //     {
        //         TreeNode curr = q.remove();
        //         if(curr.left != null)
        //         {
        //             q.add(curr.left);
        //         }
        //         if(curr.right != null)
        //         {
        //             q.add(curr.right);
        //         }

        //         if(i == size - 1)
        //             ans.add(curr.val);   
        //     }
        // }

        dfs(root,0);
        return ans;
    }
}

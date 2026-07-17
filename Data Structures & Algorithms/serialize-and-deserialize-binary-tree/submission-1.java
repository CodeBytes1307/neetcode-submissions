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

public class Codec {

    // Encodes a tree to a single string.
    private void dfs(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.

    private TreeNode build(Queue<String> q)
    {
        String val = q.remove();
        if(val.equals("N"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(q);
        root.right = build(q);
        return root;
    }
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }
}

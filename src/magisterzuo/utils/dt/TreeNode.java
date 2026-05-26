package magisterzuo.utils.dt;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(TreeNode l, TreeNode r, int val) {
        left = l;
        right = r;
        this.val = val;
    }
}

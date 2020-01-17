/**
 * 39.平衡二叉树(左右子树的高度差不超过1)：
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class BalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        if(left == -1)return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        int right = depth(root.right);
        if(right == -1)return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        /*
        if(left - right < -1 || left - right > 1){   //或使用 abs(left - right) > 1 )
            return -1;
        }else{
            return 1 + Math.max(left,right);
        }
        */
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}

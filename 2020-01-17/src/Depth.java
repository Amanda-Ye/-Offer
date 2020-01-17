import java.util.ArrayList;

/**
 *38.二叉树的深度：
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Depth {
    //非递归(题解：层次遍历)
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);
        int res = 0;
        while(level.size() > 0){
            res = res + 1;
            ArrayList<TreeNode> newLevel = new ArrayList<>();
            for(int i = 0;i < level.size();i++){
                if(level.get(i).left != null) {
                    newLevel.add(level.get(i).left);
                }
                if(level.get(i).right != null){
                    newLevel.add(level.get(i).right);
                }
            }
            level = newLevel;
        }
        return res;
    }

    //递归
    public int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = 1 + TreeDepth(root.left);
        int rightDepth = 1 + TreeDepth(root.right);
        return Math.max(leftDepth,rightDepth);
    }
}

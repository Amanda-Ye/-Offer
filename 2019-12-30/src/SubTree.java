/**
 * 17.树的子结构：（代码的鲁棒性）
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class SubTree {
    //先在 root1 中找到与 root2 根节点相同的节点，再判断两棵树结构是否相同；若找不到则返回 false
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isHasSubtree(root1,root2) || isHasSubtree(root1.left,root2) || isHasSubtree(root1.right,root2);
    }

    private boolean isHasSubtree(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isHasSubtree(root1.left,root2.left) && isHasSubtree(root1.right,root2.right);
    }
}

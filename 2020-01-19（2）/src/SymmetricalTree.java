import java.util.LinkedList;

/**
 * 58.对称二叉树：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class SymmetricalTree {
    //递归
    boolean isSymmetrical(TreeNode pRoot){
       return pRoot == null || isMirrorTree(pRoot.left,pRoot.right);
    }

    //左右子树是否互为镜像
    private boolean isMirrorTree(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        if(r1.val != r2.val){
            return false;
        }
        return isMirrorTree(r1.left,r2.right) && isMirrorTree(r1.right,r2.left);
    }

    //非递归
    //设置两个链表，分别代表左子树和右子树。左子树每次都从左往右添加节点，右子树每次都从右往左添加节点。
    boolean isSymmetrical2(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        LinkedList<TreeNode> leftList = new LinkedList<>();
        LinkedList<TreeNode> rightList = new LinkedList<>();
        leftList.add(pRoot.left);
        rightList.add(pRoot.right);
        while(!leftList.isEmpty() && !rightList.isEmpty()){
            TreeNode leftNode = leftList.poll();
            TreeNode rightNode = rightList.poll();
            if(leftNode == null && rightNode == null){
                continue;
            }
            if(leftNode == null || rightNode == null){
                return false;
            }
            if(leftNode.val != rightNode.val){
                return false;
            }
            //左子树从左往右添加结点
            leftList.add(leftNode.left);
            leftList.add(leftNode.right);
            //右子树从右往左添加结点
            rightList.add(rightNode.right);
            rightList.add(rightNode.left);
        }
        return leftList.isEmpty() && rightList.isEmpty();
    }
}
